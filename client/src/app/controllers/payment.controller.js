(function () {
    'use strict';

    angular
        .module("movie")
        .controller("userPaymentController", userPaymentController);


    userPaymentController.$inject = ["userPaymentService", "customCookieService"];
    function userPaymentController(userPaymentService, customCookieService) {

        if(customCookieService.testLoggedIn() == false)
        {
            window.location.href="./index.html";
            window.alert("User not logged in");
        }


        var userVm = this;
        userVm.user = new Object();
        userVm.getUserPayment = getUserPayment;
        userVm.editUserPayment = editUserPayment;

        var tempData = new Object();
        var userId = customCookieService.getUserId();

        /*Called on page load*/
        getUserPayment();


        function createDate(stringDate) {
            var dateSplit = stringDate.split("/");
            return dateSplit[1] + "-" + dateSplit[0] + "-" + "01";
        }

        function parseDate(stringDate) {
            stringDate = stringDate.toString();
            var dateSplit = stringDate.split("-");
            return dateSplit[1] + "/" + dateSplit[0];
        }


        function getUserPayment() {

            userPaymentService.getUserPayment(userId)
                .then(function (data) {
                    tempData = data;

                    if (tempData.payment != null) {
                        if (tempData.payment.address != null) {
                            userVm.user.addressOne = tempData.payment.address.AddressOne;
                            userVm.user.addressTwo = tempData.payment.address.AddressTwo;
                            userVm.user.zipCode = tempData.payment.address.ZipCode;
                            userVm.user.city = tempData.payment.address.City;
                            userVm.user.state = tempData.payment.address.State;
                            userVm.user.country = tempData.payment.address.Country;

                        }
                        userVm.user.ccNumber = tempData.payment.CCNumber;
                        userVm.user.ccName = tempData.payment.CCName;

                        if (tempData.payment.ExpiryDate != null)
                            userVm.user.ccExpiryDate = parseDate(tempData.payment.ExpiryDate);


                        userVm.user.ccCVV = tempData.payment.CCCVV;

                    }
                    userVm.user.contactNumber = tempData.PhoneNumber;
                }, function (error) {
                    console.log(error);
                    window.location.href="./error.html";
                })
        }


        function editUserPayment() {

            if (tempData.payment == null)
                tempData.payment = new Object();

            if (!tempData.payment.hasOwnProperty("address")) {
                tempData.payment.address = new Object();
            }


            tempData.payment.address.AddressOne = userVm.user.addressOne;
            tempData.payment.address.AddressTwo = userVm.user.addressTwo;
            tempData.payment.address.ZipCode = userVm.user.zipCode;
            tempData.payment.address.City = userVm.user.city;
            tempData.payment.address.State = userVm.user.state;
            tempData.payment.address.Country = userVm.user.country;

            tempData.payment.CCNumber = userVm.user.ccNumber;
            tempData.payment.CCName = userVm.user.ccName;
            tempData.payment.ExpiryDate = createDate(userVm.user.ccExpiryDate);
            tempData.payment.CCCVV = userVm.user.ccCVV;


            userPaymentService.editUserPayment(userId, tempData)
                .then(function (data) {
                    window.location.href = "./user-account.html";
                }, function (error) {
                    console.log(error);
                    window.location.href="./error.html";
                })


        }

    }

})();