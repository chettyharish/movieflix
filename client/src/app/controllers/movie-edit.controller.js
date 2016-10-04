(function () {
    'use strict';

    angular
        .module("movie")
        .controller("movieEditController", movieEditController);


    movieEditController.$inject = ["movieEditService", "customCookieService"];
    function movieEditController(movieEditService, customCookieService) {

        if (customCookieService.testLoggedIn() == false) {
            window.location.href = "./index.html";
            window.alert("User not logged in");
        }


        var movieVm = this;
        movieVm.editMovie = new Object();
        movieVm.getMovie = getMovie;
        movieVm.modifyMovie = modifyMovie;

        movieVm.movieId = (getUrlParams()["movieId"]).replace(/[#/]/g, "");



        function getUrlParams() {
            var param = {};
            var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi,
                function (m, key, value) {
                    param[key] = value;
                });
            return param;
        }

        getMovie();

        function getMovie() {

            movieEditService.getMovie(movieVm.movieId)
                .then(function (data) {
                    movieVm.movieData = data;

                    movieVm.editMovie.movieName = movieVm.movieData.Title
                    movieVm.editMovie.releaseDate = new Date(movieVm.movieData.Released);
                    movieVm.editMovie.rating = movieVm.movieData.Rated;
                    movieVm.editMovie.runtime = movieVm.movieData.Runtime;
                    movieVm.editMovie.genres = movieVm.movieData.Genre;
                    movieVm.editMovie.actors = movieVm.movieData.Actors;
                    movieVm.editMovie.writers = movieVm.movieData.Writer;
                    movieVm.editMovie.directors = movieVm.movieData.Director;
                    movieVm.editMovie.languages = movieVm.movieData.Language;
                    movieVm.editMovie.country = movieVm.movieData.Country;
                    movieVm.editMovie.awards = movieVm.movieData.Awards;
                    movieVm.editMovie.posterLink = movieVm.movieData.Poster;
                    movieVm.editMovie.metaScore = movieVm.movieData.Metascore;
                    movieVm.editMovie.imdbRating = movieVm.movieData.imdbRating;
                    movieVm.editMovie.imdbNumVotes = movieVm.movieData.imdbVotes;
                    movieVm.editMovie.imdbID = movieVm.movieData.imdbID;
                    movieVm.editMovie.type = movieVm.movieData.Type;
                    movieVm.editMovie.plot = movieVm.movieData.Plot;

                }, function (error) {
                    console.log(error);
                })
        }

        function modifyMovie() {
            movieVm.movieData.Title = movieVm.editMovie.movieName;
            movieVm.movieData.Released = movieVm.editMovie.releaseDate;
            movieVm.movieData.Rated = movieVm.editMovie.rating;
            movieVm.movieData.Runtime = movieVm.editMovie.runtime;
            movieVm.movieData.Genre = movieVm.editMovie.genres;
            movieVm.movieData.Actors = movieVm.editMovie.actors;
            movieVm.movieData.Writer = movieVm.editMovie.writers;
            movieVm.movieData.Director = movieVm.editMovie.directors;
            movieVm.movieData.Language = movieVm.editMovie.languages;
            movieVm.movieData.Country = movieVm.editMovie.country;
            movieVm.movieData.Awards = movieVm.editMovie.awards;
            movieVm.movieData.Poster = movieVm.editMovie.posterLink;
            movieVm.movieData.imdbRating = movieVm.editMovie.imdbRating;
            movieVm.movieData.imdbVotes = movieVm.editMovie.imdbNumVotes;
            movieVm.movieData.imdbID = movieVm.editMovie.imdbID;
            movieVm.movieData.Type = movieVm.editMovie.type;
            movieVm.movieData.Plot = movieVm.editMovie.plot;

            movieEditService.editMovie(movieVm.movieId, movieVm.movieData)
                .then(function (data) {
                    movieVm.movieData = data
                    window.location.href="./main-grid.html";

                }, function (error) {
                    console.log(error);
                })
        }

    }

})();