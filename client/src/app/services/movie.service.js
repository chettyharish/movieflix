(function () {
    'use strict';

    angular
        .module("movie")
        .service("movieService", movieService);


    movieService.$inject = ["$http", "$q", "CONFIG"];
    function movieService($http, $q, CONFIG) {
        var self = this;
        self.getMovie = getMovie;
        self.getCommentList = getCommentList;
        self.addComment = addComment;

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


        function getCommentList(movieId) {
            var url = CONFIG.API_HOST + "movies/" + movieId + "/commentList";
            return $http
                .get(url)
                .then(function (response) {
                        return response.data;
                    }, function (error) {
                        return $q.reject(error);
                    }
                )
        }

        function addComment(movieId, movie) {
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