(function () {
    'use strict';

    angular
        .module("movie")
        .service("mainService", mainService);


    mainService.$inject = ["$http", "$q"];
    function mainService($http, $q) {
        console.log("mainService");
        var self = this;
        self.getAllMovies = getAllMovies;


        function getAllMovies(movieId) {
            console.log("getAllMovies");
            var url = "http://localhost:8080/movie/api/movies/";
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