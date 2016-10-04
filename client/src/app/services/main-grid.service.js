(function () {
    'use strict';

    angular
        .module("movie")
        .service("mainService", mainService);


    mainService.$inject = ["$http", "$q"];
    function mainService($http, $q) {
        var self = this;
        self.getAllMovies = getAllMovies;


        function getAllMovies(movieId) {
            var url = "http://localhost:8080/movie/api/movies/";
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