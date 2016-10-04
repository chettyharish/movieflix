(function () {
    'use strict';

    angular
        .module("movie")
        .controller("movieDeleteController", movieDeleteController);


    movieDeleteController.$inject = ["movieDeleteService", "customCookieService"];
    function movieDeleteController(movieDeleteService, customCookieService) {
        console.log("movieDeleteController");

        if (customCookieService.testLoggedIn() == false) {
            window.location.href = "./index.html";
            window.alert("User not logged in");
        }


        var movieVm = this;
        movieVm.delMovie = new Object();
        movieVm.getMovie = getMovie;
        movieVm.deleteMovie = deleteMovie;

        movieVm.movieId = (getUrlParams()["movieId"]).replace(/[#/]/g, "");

        getMovie();


        function getUrlParams() {
            var param = {};
            var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi,
                function (m, key, value) {
                    param[key] = value;
                });
            return param;
        }


        function getMovie() {
            console.log("getMovie");
            var movieData;

            movieDeleteService.getMovie(movieVm.movieId)
                .then(function (data) {
                    movieVm.movieData = data;
                    movieVm.delMovie.rating = movieVm.movieData.Rated;
                    movieVm.delMovie.type = movieVm.movieData.Type;
                    movieVm.delMovie.releaseDate = new Date(movieVm.movieData.Released);
                }, function (error) {
                    console.log(error);
                    window.location.href="./error.html";
                })
        }

        function deleteMovie() {
            movieDeleteService.deleteMovie(movieVm.movieId)
                .then(function (data) {
                    window.location.href="./main-grid.html";
                }, function (error) {
                    console.log(error);
                    window.location.href="./error.html";
                })
        }

    }

})();