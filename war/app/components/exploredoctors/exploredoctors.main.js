var exploredoctors = require('html-loader!./exploredoctors.html');

angular.module('hplus.modules.exploredoctors', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/admin/list/doctor',{
        template: exploredoctors
      })
  });