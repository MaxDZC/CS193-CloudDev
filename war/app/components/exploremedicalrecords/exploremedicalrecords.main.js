var exploremedicalrecords = require('html-loader!./exploremedicalrecords.html');

angular.module('hplus.modules.exploremedicalrecords', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/admin/list/record',{
        template: exploremedicalrecords
      })
  });

require('./exploremedicalrecords.directive.js');
require('./exploremedicalrecords.controller.js');