var editdoctor = require('html-loader!./editdoctor.html');

angular.module('hplus.modules.editdoctor', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/admin/edit/doctor',{
        template: editdoctor
      })
  });
