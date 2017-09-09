var viewdoctor = require('html-loader!./viewdoctor.html');

angular.module('hplus.modules.viewdoctor', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/admin/view/details',{
        template: viewdoctor
      })
  });

  require('./viewdoctor.controller.js');