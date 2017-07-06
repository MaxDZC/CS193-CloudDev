var editdisease = require('html-loader!./editdisease.html');

angular.module('hplus.modules.editdisease', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/admin/update/disease',{
        template: editdisease
      })
  });
