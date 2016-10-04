(function () {
    'use strict';

    angular
        .module("movie")
        .service("movieAddService", movieAddService);


    movieAddService.$inject = ["$http", "$q", "CONFIG"];
    function movieAddService($http, $q, CONFIG) {
        console.log("movieAddService");
        var self = this;
        self.addMovie = addMovie;

        function addMovie(Movie) {
            return $http
                .post(CONFIG.API_HOST + "movies", JSON.stringify(Movie))
                .then(function (response) {
                        return response.data;
                    }, function (error) {
                        return $q.reject(error);
                    }
                )
        }
    }

})();