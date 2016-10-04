(function () {
    'use strict';

    angular
        .module("movie")
        .service("signUpService", signUpService);


    signUpService.$inject = ["$http", "$q", "CONFIG"];
    function signUpService($http , $q, CONFIG) {
        var self = this;
        self.addUserAuthenticator = addUserAuthenticator;
        self.addBaseUserInformation = addBaseUserInformation;

        function addUserAuthenticator(authenticatorUser) {
            
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