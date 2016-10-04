(function () {
    'use strict';

    angular
        .module("movie")
        .controller("mainController", mainController);


    mainController.$inject = ["mainService" ,"customCookieService"] ;
    function mainController(mainService, customCookieService) {
        console.log("mainController");
        if(customCookieService.testLoggedIn() == false)
        {
            window.location.href="./index.html";
            window.alert("User not logged in");
        }


        var movieVm = this;
        movieVm.viewPort = {};
        movieVm.viewPort.type = "grid";

        movieVm.getAllMovies = getAllMovies;
        movieVm.toggleSort = toggleSort;
        movieVm.filterBy = filterBy;
        movieVm.toggleFilter = toggleFilter;
        movieVm.changePage = changePage;
        movieVm.prevPage = prevPage;
        movieVm.nextPage = nextPage;
        movieVm.getRange = getRange;
        movieVm.getPagesByType = getPagesByType;
        movieVm.setViewPort = setViewPort;

        movieVm.page = {
            pageNumber: 1,
            pageSize: 12,
            numPages: 0
        };


        movieVm.sorter = {
            by: "Title",
            reverse: false
        };

        movieVm.filter = {
            by: "all"
        };


        getAllMovies();


        function setViewPort(viewport) {
            movieVm.viewPort.type = viewport;
        }

        function getUrlParams() {
            var param = {};
            var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi,
                function (m, key, value) {
                    param[key] = value;
                });
            return param;
        }

        function getPagesByType() {
            if (movieVm.filter.by == "all")
                return Math.ceil(movieVm.movieData.length / movieVm.page.pageSize);

            var count = 0;
            for (var i = 0; i < movieVm.movieData.length; i++) {
                if (movieVm.movieData[i].Type == movieVm.filter.by)
                    count = count + 1;
            }
            return Math.ceil(count / movieVm.page.pageSize);
        }

        function setParams() {
            console.log("setParams")
            var param = getUrlParams()["filterBy"].replace(/[#/]/g, "");
            if (param != null)
                toggleFilter(param)
        }

        function getRange() {
            console.log("getRange")
            console.log(movieVm.page.numPages)
            return new Array(movieVm.page.numPages);
        }


        function nextPage() {
            console.log("nextPage")
            if (movieVm.page.pageNumber < movieVm.page.numPages)
                movieVm.page.pageNumber = movieVm.page.pageNumber + 1;
        }

        function prevPage() {
            console.log("prevPage")
            if (movieVm.page.pageNumber > 1)
                movieVm.page.pageNumber = movieVm.page.pageNumber - 1;
        }

        function changePage(pageNumber) {
            movieVm.page.pageNumber = pageNumber;
        }

        function filterBy(item) {
            if (movieVm.filter.by === item.Type || movieVm.filter.by === "all")
                return true;
        }

        function toggleFilter(filter) {
            movieVm.filter.by = filter;
            console.log("toggleFilter " + movieVm.filter.by);
            movieVm.page.numPages = movieVm.getPagesByType();
            movieVm.page.pageNumber = 1;
            console.log(movieVm.page.numPages)

        }

        function toggleSort(sortBy) {
            console.log("sortBy " + sortBy);
            movieVm.sorter.by = sortBy;
            movieVm.sorter.reverse = !movieVm.sorter.reverse;
        }


        function getAllMovies() {
            console.log("getAllMovies");

            mainService.getAllMovies()
                .then(function (data) {
                    movieVm.movieData = data;
                    console.log(movieVm.movieData);

                    setParams();
                    movieVm.page.numPages = movieVm.getPagesByType();
                    console.log(movieVm.page.numPages)
                }, function (error) {
                   
                    console.log(error);
                })

        }

    }

})();