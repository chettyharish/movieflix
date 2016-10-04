(function () {
    'use strict';

    angular
        .module("movie")
        .service("userAccountService", userAccountService);


    userAccountService.$inject = ["$http", "$q", "CONFIG"];
    function userAccountService($http, $q, CONFIG) {
        console.log("userAccountService");
        var self = this;
        self.getUser = getUser;


        function getUser(userId) {
            var url = CONFIG.API_HOST + "users/" + userId;
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