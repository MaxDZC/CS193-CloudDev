var explorepatients = require('html-loader!./explorepatients.html');

angular.module('hplus.modules.explorepatients', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/admin/list/patient',{
        template: explorepatients,
      })
  });
  
  require('./explorepatients.directive.js');
  require('./explorepatients.controller.js');
  require('./xxpatientcard.controller.js');
