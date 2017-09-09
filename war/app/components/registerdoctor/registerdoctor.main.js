var registerdoctor = require('html-loader!./registerdoctor.html');

angular.module('hplus.modules.registerdoctor', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/admin/register/doctor',{
        template: registerdoctor
      })
  });

  require('./registerdoctor.controller.js');