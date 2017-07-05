var editdisease = require('html-loader!./editdisease.html');

angular.module('hplus.modules.editdisease', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/admin/edit/disease',{
        template: editdisease
      })
  });
