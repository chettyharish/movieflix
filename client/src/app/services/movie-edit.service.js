(function () {
    'use strict';

    angular
        .module("movie")
        .service("movieEditService", movieEditService);


    movieEditService.$inject = ["$http", "$q", "CONFIG"];
    function movieEditService($http, $q, CONFIG) {
        var self = this;
        self.getMovie = getMovie;
        self.editMovie = editMovie;


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
        }


        function editMovie(movieId, movie) {
            var url = CONFIG.API_HOST + "movies/" + movieId;
            return $http
                .put(url, JSON.stringify(movie))
                .then(function (response) {
                        return response.data;
                    }, function (error) {
                        return $q.reject(error);
                    }
                )
        }
    }

})();