(function () {
    'use strict';

    angular
        .module("movie")
        .service("userEditService", userEditService);


    userEditService.$inject = ["$http", "$q", "CONFIG"];
    function userEditService($http, $q, CONFIG) {
        console.log("userEditService");
        var self = this;
        self.getUser = getUser;
        self.editUser = editUser;


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

        function editUser(userId, user) {
            console.log("editUser Service");
            var url = CONFIG.API_HOST + "users/" + userId;
            console.log(url);
            console.log(JSON.stringify(user));
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