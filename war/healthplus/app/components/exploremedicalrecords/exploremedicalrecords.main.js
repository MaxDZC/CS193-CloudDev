var exploremedicalrecords = require('html-loader!./exploremedicalrecords.html');

angular.module('hplus.modules.exploremedicalrecords', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/doctor/list/record',{
        template: exploremedicalrecords
      })
  });
