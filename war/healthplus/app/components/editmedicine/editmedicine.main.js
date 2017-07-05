var editmedicine = require('html-loader!./editmedicine.html');

angular.module('hplus.modules.editmedicine', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/admin/edit/medicine',{
        template: editmedicine
      })
  });
