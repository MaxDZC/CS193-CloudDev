var viewdisease = require('html-loader!./viewdisease.html');

angular.module('hplus.modules.viewdisease', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/admin/view/disease',{
        template: viewdisease
      })
  });

  require('./viewdisease.controller.js');