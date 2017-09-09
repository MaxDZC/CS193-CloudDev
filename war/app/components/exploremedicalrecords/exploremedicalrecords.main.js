var exploremedicalrecords = require('html-loader!./exploremedicalrecords.html');

angular.module('hplus.modules.exploremedicalrecords', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/admin/list/record',{
        template: exploremedicalrecords
      })
  });
