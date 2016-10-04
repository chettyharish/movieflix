(function () {
    'use strict';

    angular
        .module("movie")
        .service("customCookieService", customCookieService);

    customCookieService.$inject = ["$cookies"];
    function customCookieService($cookies) {
        var cookieVm = this;
        cookieVm.deleteCookie = deleteCookie;
        cookieVm.getUserId = getUserId;
        cookieVm.testLoggedIn = testLoggedIn;
        cookieVm.testAccess = testAccess;

        function testLoggedIn() {
            if ($cookies.get("UserID", {path: "/"}) == null) {
                console.log("Not logged in");
                return false;
            }
            return true;

        }

        function deleteCookie() {
            $cookies.put('UserID', null, {path: "/"});
            $cookies.put('UserName', null, {path: "/"});
            $cookies.put('Password', null, {path: "/"});
            $cookies.put('Type', null, {path: "/"});

            $cookies.remove('UserID', {path: "/"});
            $cookies.remove('UserName', {path: "/"});
            $cookies.remove('Password', {path: "/"});
            $cookies.remove('Type', {path: "/"});

        }

        function getUserId() {
            console.log("getUserId");
            console.log($cookies.get("UserID", {path: "/"}));
            console.log($cookies.get("Type", {path: "/"}));
            return $cookies.get("UserID");
        }

        function testAccess() {
            console.log($cookies.get("Type"));
            console.log($cookies.get("Type") === "ADMIN")
            if ($cookies.get("Type") === "ADMIN") {
                return true;
            }
            return false;
        }
    }


})();