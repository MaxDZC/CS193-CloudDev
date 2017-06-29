var explorediseases = require('html-loader!./explorediseases.html');

angular.module('hplus.modules.explorediseases', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/',{
        template: explorediseases
      })
      
      .when('/diseases/explore',{
        template: explorediseases
      })
  });
