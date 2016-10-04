(function () {
    'use strict';

    angular
        .module("movie")
        .service("signUpService", signUpService);


    signUpService.$inject = ["$http", "$q", "CONFIG"];
    function signUpService($http , $q, CONFIG) {
        console.log("signUpService");
        var self = this;
        self.addUserAuthenticator = addUserAuthenticator;
        self.addBaseUserInformation = addBaseUserInformation;

        function addUserAuthenticator(authenticatorUser) {
            console.log("addUserAuthenticator");
            
            return $http
                .post(CONFIG.API_HOST + "authenticators", JSON.stringify( authenticatorUser))
                .then(function (response) {
                        return response.data;
                    }, function (error) {
                        return $q.reject(error);
                    }
                )

        }


        function addBaseUserInformation(baseUserInfo) {
            console.log("addBaseUserInformation");

            return $http
                .post(CONFIG.API_HOST + "users", JSON.stringify( baseUserInfo))
                .then(function (response) {
                        return response.data;
                    }, function (error) {
                        return $q.reject(error);
                    }
                )

        }
    }

})();