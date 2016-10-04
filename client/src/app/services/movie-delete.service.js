(function () {
    'use strict';

    angular
        .module("movie")
        .service("movieDeleteService", movieDeleteService);


    movieDeleteService.$inject = ["$http", "$q", "CONFIG"];
    function movieDeleteService($http, $q, CONFIG) {
        console.log("movieDeleteService");
        var self = this;
        self.getMovie = getMovie;
        self.deleteMovie = deleteMovie;


        function getMovie(movieId) {
            console.log("getMovie");
            console.log(movieId);
            var url = CONFIG.API_HOST + "movies/" + movieId;
            console.log(url);
            return $http
                .get(url)
                .then(function (response) {
                        return response.data;
                    }, function (error) {
                        return $q.reject(error);
                    }
                )
        };

        function deleteMovie(movieId) {
            console.log("deleteMovie");
            var url = CONFIG.API_HOST + "movies/" + movieId;
            console.log("DEL : " + url);
            return $http
                .delete(url)
                .then(function () {
                        return;
                    }, function (error) {
                        return $q.reject(error);
                    }
                )
        };
    }

})();


