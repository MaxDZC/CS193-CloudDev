var registermedicalrecord = require('html-loader!./registermedicalrecord.html');

angular.module('hplus.modules.registermedicalrecord', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/doctor/register/record',{
        template: registermedicalrecord
      })
  });
  
  require('./registermedicalrecord.controller.js');
