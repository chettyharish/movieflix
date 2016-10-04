(function () {
    'use strict';

    angular
        .module("movie")
        .service("userEditService", userEditService);


    userEditService.$inject = ["$http", "$q", "CONFIG"];
    function userEditService($http, $q, CONFIG) {
        var self = this;
        self.getUser = getUser;
        self.editUser = editUser;


        function getUser(userId) {
            var url = CONFIG.API_HOST + "users/" + userId;
            return $http
                .get(url)
                .then(function (response) {
                        return response.data;
                    }, function (error) {
                        return $q.reject(error);
                    }
                )
        }

        function editUser(userId, user) {
            var url = CONFIG.API_HOST + "users/" + userId;
            return $http
                .put(url, JSON.stringify(user))
                .then(function (response) {
                        return response.data;
                    }, function (error) {
                        return $q.reject(error);
                    }
                )

        }
    }

})();