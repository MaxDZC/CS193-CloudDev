var editmedicine = require('html-loader!./editmedicalrecord.html');

angular.module('hplus.modules.editmedicalrecord', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/update/medicalrecord',{
        template: editmedicine
      })
  });

  require('./editmedicalrecord.controller.js');