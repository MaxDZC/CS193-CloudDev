var registerdoctor = require('html-loader!./registerdoctor.html');

angular.module('hplus.modules.registerdoctor', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/register',{
        template: registerdoctor
      })
  });
