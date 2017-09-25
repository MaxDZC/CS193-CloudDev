var editmedicalrecord = require('html-loader!./editmedicalrecord.html');

angular.module('hplus.modules.editmedicalrecord', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/doctor/edit/record',{
        template: editmedicalrecord
      })
  });
  require('./editmedicalrecord.controller.js');
