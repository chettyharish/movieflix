(function () {
    'use strict';

    angular
        .module("movie")
        .controller("signUpController", signUpController);


    signUpController.$inject = ["signUpService"];
    function signUpController(signUpService) {
        var signUpVm = this;
        signUpVm.createUser = createUser;


        function createUser() {

            var authenticatorUser = {
                "UserName": signUpVm.newUser.userName,
                "Password": signUpVm.newUser.password,
                "Type": "USER"
            };

            var baseUserInfo = {
                "UserName": signUpVm.newUser.userName,
                "EmailAddress": signUpVm.newUser.email,
                "CreateDate": new Date().toISOString().split('T')[0] + " " + new Date().toISOString().split('T')[1].split('.')[0],
                "UpdateDate": new Date().toISOString().split('T')[0] + " " + new Date().toISOString().split('T')[1].split('.')[0],
                "BirthDate": signUpVm.newUser.birthDate
            };


            signUpService.addBaseUserInformation(baseUserInfo)
                .then(function (data) {
                    signUpVm.baseUserInfo = data;
                    authenticatorUser.UserID = signUpVm.baseUserInfo.userId;

                    signUpService.addUserAuthenticator(authenticatorUser)
                        .then(function (data) {
                            signUpVm.authUser = data;
                            window.location.href = "./main-grid.html";
                        }, function (error) {
                            window.alert("UserName and Email already in use")
                            console.log(error);
                        })
                }, function (error) {
                    console.log(error);
                });


        }
    }

})();