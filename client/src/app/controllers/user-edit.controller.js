(function () {
    'use strict';

    angular
        .module("movie")
        .controller("userEditController", userEditController);


    userEditController.$inject = ["userEditService", "customCookieService"];
    function userEditController(userEditService, customCookieService) {
        console.log("userEditController");
        if (customCookieService.testLoggedIn() == false) {
            window.location.href = "./index.html";
            window.alert("User not logged in");
        }

        var userVm = this;
        userVm.user = new Object();
        userVm.getUser = getUser;
        userVm.editUser = editUser;

        var tempData = new Object();
        var userId = customCookieService.getUserId();

        /*Called on page load*/
        getUser();

        function parseDate(stringDate) {
            var dateSplit = stringDate.split("-");
            return new Date(dateSplit[0], dateSplit[1] - 1, dateSplit[2]);
        }

        function getUser() {
            console.log("getUser");

            userEditService.getUser(userId)
                .then(function (data) {
                    tempData = data;
                    userVm.user.firstName = tempData.FirstName;
                    userVm.user.lastName = tempData.LastName;
                    userVm.user.birthDate = parseDate(tempData.BirthDate);
                    userVm.user.genderType = tempData.Gender;
                    userVm.user.contactNumber = tempData.PhoneNumber;

                    if (tempData.address != null) {
                        userVm.user.addressOne = tempData.address.AddressOne;
                        userVm.user.addressTwo = tempData.address.AddressTwo;
                        userVm.user.zipCode = tempData.address.ZipCode;
                        userVm.user.city = tempData.address.City;
                        userVm.user.state = tempData.address.State;
                        userVm.user.country = tempData.address.Country;
                    }
                    console.log(data)
                }, function (error) {

                    console.log(error);
                })
        }


        function editUser() {
            console.log("editUser Controller");

            tempData.FirstName = userVm.user.firstName;
            tempData.LastName = userVm.user.lastName;
            tempData.BirthDate = new Date(userVm.user.birthDate);
            tempData.Gender = userVm.user.genderType;
            tempData.PhoneNumber = userVm.user.contactNumber;


            if (tempData.address == null)
                tempData.address = new Object();

            tempData.address.AddressOne = userVm.user.addressOne;
            tempData.address.AddressTwo = userVm.user.addressTwo;
            tempData.address.ZipCode = userVm.user.zipCode;
            tempData.address.City = userVm.user.city;
            tempData.address.State = userVm.user.state;
            tempData.address.Country = userVm.user.country;


            console.log("editUser");

            userEditService.editUser(userId, tempData)
                .then(function (data) {
                    console.log(data);
                    window.location.href = "./user-account.html";
                }, function (error) {

                    console.log(error);
                })


        }

    }

})();