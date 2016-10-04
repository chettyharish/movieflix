(function () {
    'use strict';

    angular
        .module("movie")
        .service("movieDeleteService", movieDeleteService);


    movieDeleteService.$inject = ["$http", "$q", "CONFIG"];
    function movieDeleteService($http, $q, CONFIG) {
        var self = this;
        self.getMovie = getMovie;
        self.deleteMovie = deleteMovie;


        function getMovie(movieId) {
            var url = CONFIG.API_HOST + "movies/" + movieId;
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
            var url = CONFIG.API_HOST + "movies/" + movieId;
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


