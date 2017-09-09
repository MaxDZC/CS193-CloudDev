var viewmedicine = require('html-loader!./viewmedicine.html');

angular.module('hplus.modules.viewmedicine', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/admin/view/medicine',{
        template: viewmedicine
      })
  });

  require('./viewmedicine.controller.js');