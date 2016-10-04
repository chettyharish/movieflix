(function () {
    'use strict';

    angular.module("movie", ["ui.bootstrap", "ngMessages", "ngCookies"])
        .run(moduleRun);

    function moduleRun() {
        console.log('app started');
    }
})();