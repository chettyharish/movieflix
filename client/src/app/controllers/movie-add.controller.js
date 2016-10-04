(function () {
    'use strict';

    angular
        .module("movie")
        .controller("movieAddController", movieAddController);


    movieAddController.$inject = ["movieAddService", "customCookieService"];
    function movieAddController(movieAddService, customCookieService) {
        console.log("movieAddController");

        if (customCookieService.testLoggedIn() == false) {
            window.location.href = "./index.html";
            window.alert("User not logged in");
        }

        var movieVm = this;
        movieVm.addMovie = addMovie;


        function addMovie() {
            console.log("addMovie");
            var Movie = {
                "Title": movieVm.newMovie.movieName,
                "Year": movieVm.newMovie.releaseDate.getFullYear(),
                "Rated": movieVm.newMovie.rating,
                "Released": movieVm.newMovie.releaseDate,
                "Runtime": movieVm.newMovie.runtime,
                "Genre": movieVm.newMovie.genres,
                "Director": movieVm.newMovie.directors,
                "Writer": movieVm.newMovie.writers,
                "Actors": movieVm.newMovie.actors,
                "Language": movieVm.newMovie.languages,
                "Country": movieVm.newMovie.country,
                "Plot": movieVm.newMovie.plot,
                "Awards": movieVm.newMovie.awards,
                "Poster": movieVm.newMovie.posterLink,
                "Metascore": movieVm.newMovie.metaScore,
                "imdbRating": movieVm.newMovie.imdbRating,
                "imdbVotes": movieVm.newMovie.imdbNumVotes,
                "imdbID": movieVm.newMovie.imdbID,
                "Type": movieVm.newMovie.type

            };

            console.log(JSON.stringify(Movie));
            movieAddService.addMovie(Movie)
                .then(function (data) {
                    movieVm.Movie = data;
                    window.location.href="./main-grid.html";
                }, function (error) {
                    console.log(error);
                })
        }

    }

})();