var registerdiseases = require('html-loader!./registerdiseases.html');

angular.module('hplus.modules.registerdiseases', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/diseases/register',{
        template: registerdiseases
      })
  });
