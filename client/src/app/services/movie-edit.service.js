(function () {
    'use strict';

    angular
        .module("movie")
        .service("movieEditService", movieEditService);


    movieEditService.$inject = ["$http", "$q", "CONFIG"];
    function movieEditService($http, $q, CONFIG) {
        console.log("movieEditService");
        var self = this;
        self.getMovie = getMovie;
        self.editMovie = editMovie;


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
        }


        function editMovie(movieId, movie) {
            console.log("editMovie");
            console.log(movieId);
            var url = CONFIG.API_HOST + "movies/" + movieId;
            console.log(url);
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