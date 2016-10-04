(function () {
    'use strict';

    angular
        .module("movie")
        .controller("userAccountController", userAccountController);


    userAccountController.$inject = ["userAccountService", "customCookieService"];
    function userAccountController(userAccountService, customCookieService) {

        if (customCookieService.testLoggedIn() == false) {
            window.location.href = "./index.html";
            window.alert("User not logged in");
        }

        var userVm = this;
        userVm.user = new Object();
        userVm.getUser = getUser;

        var tempData = new Object();
        var userId = customCookieService.getUserId();


        getUser();

        function parseDate(stringDate) {
            var dateSplit = stringDate.split("-");
            return new Date(dateSplit[0], dateSplit[1] - 1, 0);
        }


        function getUser() {

            userAccountService.getUser(userId)
                .then(function (data) {
                    tempData = data;

                    userVm.user.userName = tempData.UserName;
                    userVm.user.email = tempData.EmailAddress;
                    userVm.user.contactNumber = tempData.PhoneNumber;
                    userVm.user.firstName = tempData.FirstName;
                    userVm.user.lastName = tempData.LastName;
                    userVm.user.birthDate = tempData.BirthDate;
                    userVm.user.gender = tempData.Gender;

                    if (tempData.address != null) {
                        userVm.user.addressOne = tempData.address.AddressOne;
                        userVm.user.addressTwo = tempData.address.AddressTwo;
                        userVm.user.zipCode = tempData.address.ZipCode;
                        userVm.user.city = tempData.address.City;
                        userVm.user.state = tempData.address.State;
                        userVm.user.country = tempData.address.Country;
                    }

                    if (tempData.payment != null) {
                        if (tempData.payment.address != null) {

                            if (userVm.payment == null)
                                userVm.user.payment = new Object();
                            userVm.user.payment.addressOne = tempData.payment.address.AddressOne;
                            userVm.user.payment.addressTwo = tempData.payment.address.AddressTwo;
                            userVm.user.payment.zipCode = tempData.payment.address.ZipCode;
                            userVm.user.payment.city = tempData.payment.address.City;
                            userVm.user.payment.state = tempData.payment.address.State;
                            userVm.user.payment.country = tempData.payment.address.Country;
                            userVm.user.payment.ccName = tempData.payment.CCName;

                            userVm.user.payment.expiry = tempData.payment.ExpiryDate;
                            userVm.user.payment.ccNumber = "**** **** **** " + tempData.payment.CCNumber.substring(tempData.payment.CCNumber.length - 4, tempData.payment.CCNumber - 1);
                        }

                        userVm.user.ccName = tempData.payment.CCName;
                        if (tempData.payment.ExpiryDate != null)
                            userVm.user.ccExpiryDate = parseDate(tempData.payment.ExpiryDate);

                    }

                }, function (error) {
                    console.log(error);
                    window.location.href="./error.html";
                })
        }


    }

})();