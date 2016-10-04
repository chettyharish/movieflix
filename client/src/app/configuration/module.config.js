(function () {
    'use strict'

    angular
        .module("movie")
        .config(moduleConfig);


    moduleConfig.inject = ["$logProvider"];
    function moduleConfig($logProvider) {
        $logProvider.debugEnabled(true);
    }
})();