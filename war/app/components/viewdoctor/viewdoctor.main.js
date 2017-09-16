var viewdoctor = require('html-loader!./viewdoctor.html');

angular.module('hplus.modules.viewdoctor', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/admin/view/doctordetails',{
        template: viewdoctor
      })
  });

  require('./viewdoctor.directive.js');
  require('./viewdoctor.controller.js');