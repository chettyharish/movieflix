(function () {
    'use strict';

    angular
        .module("movie")
        .controller("navbarController", navbarController);

    navbarController.$inject = ["$scope" , "customCookieService"];
    function navbarController($scope , customCookieService) {

        var navVm = this;

        navVm.logOut = logOut;

        function logOut(){
            customCookieService.deleteCookie();
            window.location.href = "./index.html";

        }

        $scope.isNavCollapsed = true;
        $scope.isCollapsed = false;
        $scope.isCollapsedHorizontal = false;

        $scope.status = {
            isopen: false
        };

        $scope.toggleDropdown = function ($event) {

            $event.preventDefault();
            $event.stopPropagation();
            $scope.status.isopen = !$scope.status.isopen;
        };

        $scope.appendToEl = angular.element(document.querySelector('#dropdown-long-content'));
    }

})();