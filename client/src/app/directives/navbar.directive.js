(function () {
    'use strict';

    angular
        .module("movie")
        .directive("navbarDirective", navbarDirective);


    function navbarDirective() {
        console.log("navbarDirective")
        var directive = {
            templateUrl: 'templates/navbar.tmpl.html',
            replace: true
        }

        return directive;
    }

})();