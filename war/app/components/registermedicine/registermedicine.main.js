var registermedicine = require('html-loader!./registermedicine.html');

angular.module('hplus.modules.registermedicine', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/admin/register/medicine',{
        template: registermedicine
      })
  });

  require('./registermedicine.controller.js');