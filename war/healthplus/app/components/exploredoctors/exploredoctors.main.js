var exploredoctors = require('html-loader!./exploredoctors.html');

angular.module('hplus.modules.exploredoctors', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/List/SearchRegisteredDoctors',{
        template: exploredoctors
      })
  });
