var editmedicalrecord = require('html-loader!./editmedicalrecord.html');

angular.module('hplus.modules.editmedicalrecord', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/update/medicalrecord',{
        template: editmedicalrecord	
      })
  });

  require('./editmedicalrecord.controller.js');

