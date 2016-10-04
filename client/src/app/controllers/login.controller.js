(function () {
    'use strict';

    angular
        .module("movie")
        .controller("loginController", loginController);

    loginController.$inject = ["$cookies", "loginService"];
    function loginController($cookies, loginService) {
        console.log("loginController");

        console.log($cookies.get('UserName', {path: "/"}))

        var loginVm = this;
        loginVm.authenticateUser = authenticateUser;


        function authenticateUser() {
            console.log("authenticateUser");

            loginService.authenticateUser(loginVm.user.userName, loginVm.user.password)
                .then(function (data) {
                    loginVm.baseUserInfo = data;
                    console.log(loginVm.baseUserInfo)

                    if (loginVm.user.remember == true) {
                        var expireDate = new Date();
                        expireDate.setDate(expireDate.getDate() + 7);
                        $cookies.put('UserID', loginVm.baseUserInfo.UserID, {path: "/", 'expires': expireDate});
                        $cookies.put('UserName', loginVm.baseUserInfo.UserName, {path: "/", 'expires': expireDate});
                        $cookies.put('Password', loginVm.baseUserInfo.Password, {path: "/", 'expires': expireDate});
                        $cookies.put('Type', loginVm.baseUserInfo.Type, {path: "/", 'expires': expireDate});
                    } else {
                        $cookies.put('UserID', loginVm.baseUserInfo.UserID, {path: "/"});
                        $cookies.put('UserName', loginVm.baseUserInfo.UserName, {path: "/"});
                        $cookies.put('Password', loginVm.baseUserInfo.Password, {path: "/"});
                        $cookies.put('Type', loginVm.baseUserInfo.Type, {path: "/"});

                    }


                    window.location.href="./main-grid.html";


                }, function (error) {
                    window.alert("ERROR : " + error.message);
                    console.log(error);
                })

        }

    }

})();