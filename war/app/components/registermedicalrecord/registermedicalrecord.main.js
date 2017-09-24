var registermedicalrecord = require('html-loader!./registermedicalrecord.html');

angular.module('hplus.modules.registermedicalrecord', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/doctor/register/record',{
        template: registermedicalrecord
      })
  });
  require('./xxdetailscard.controller.js');
  require('./registermedicalrecord.directive.js');
  require('./registermedicalrecord.controller.js');
