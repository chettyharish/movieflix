(function () {
    'use strict';

    angular
        .module("movie")
        .service("userPaymentService", userPaymentService);


    userPaymentService.$inject = ["$http", "$q", "CONFIG"];
    function userPaymentService($http, $q, CONFIG) {
        console.log("userPaymentService");
        var self = this;
        self.getUserPayment = getUserPayment;
        self.editUserPayment = editUserPayment;


        function getUserPayment(userId) {
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

        function editUserPayment(userId, user) {
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