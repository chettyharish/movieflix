(function () {
    'use strict';

    angular
        .module("movie")
        .service("loginService", loginService);


    loginService.$inject = ["$http", "$q", "CONFIG"];
    function loginService($http, $q, CONFIG) {
        console.log("loginService");
        var self = this;
        self.authenticateUser = authenticateUser;

        function authenticateUser(username, password) {
            console.log("authenticateUser");
            var url = CONFIG.API_HOST + "authenticators?username=" + username + "&password=" + password;
            console.log(url);

            return $http
                .get(url)
                .then(function (response) {
                        return response.data;
                    }, function (error) {
                        return $q.reject(error);
                    }
                )
        }
    }

})();