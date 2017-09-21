var viewmedicine = require('html-loader!./viewmedicine.html');

angular.module('hplus.modules.viewmedicine', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/admin/view/medicine',{
        template: viewmedicine
      })
  });
  require('./viewmedicine.directive.js');
  require('./viewmedicine.controller.js');
  require('./xxrecordcard.controller.js');