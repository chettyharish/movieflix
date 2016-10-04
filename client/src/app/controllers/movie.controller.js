(function () {
    'use strict';

    angular
        .module("movie")
        .controller("movieController", movieController);


    movieController.$inject = ["movieService", "customCookieService"];
    function movieController(movieService, customCookieService) {

        if (customCookieService.testLoggedIn() == false) {
            window.location.href = "./index.html";
            window.alert("User not logged in");
        }

        var movieVm = this;
        movieVm.getMovie = getMovie;
        movieVm.addComment = addComment;
        movieVm.setMovieRating = setMovieRating;
        movieVm.getUrlParams = getUrlParams;
        movieVm.allowedAccess = false;
        movieVm.movieData = {};
        movieVm.userRating = {};

        var movieId = (getUrlParams()["movieId"]).replace(/[#/]/g, "");


        getMovie();
        testAccess();

        function getUrlParams() {
            var param = {};
            var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi,
                function (m, key, value) {
                    param[key] = value;
                });

            return param;
        }

        function testAccess() {
            if (customCookieService.testAccess() === true) {
                movieVm.allowedAccess = true;
                return;
            }
            movieVm.allowedAccess = false;
        }

        function setMovieRating(commentList) {
            if (commentList == null)
                movieVm.userRating.rating = 0;
            var sum = 0;

            for (var i = 0; i < commentList.length; i++) {
                sum = sum + parseInt(commentList[i].Rating);

            }
            movieVm.userRating.rating = sum / commentList.length;

        }

        function getMovie() {

            movieService.getMovie(movieId)
                .then(function (data) {
                    movieVm.movieData = data;
                }, function (error) {
                    console.log(error);
                })

            movieService.getCommentList(movieId)
                .then(function (data) {
                    movieVm.movieData.commentList = data;
                    movieVm.setMovieRating(movieVm.movieData.commentList);
                }, function (error) {
                    console.log(error);
                })
        }

        function addComment() {
            var comment = {
                "Text": movieVm.comment.comment,
                "Rating": movieVm.comment.star,
                "UserName": "chettyharish"
            };


            if (movieVm.movieData.commentList == null)
                movieVm.movieData.commentList = new Object();
            movieVm.movieData.commentList.push(comment);

            movieService.addComment(movieId, movieVm.movieData)
                .then(function (data) {
                    comment = data;
                }, function (error) {
                    console.log(error);
                })

        }
    }

})();