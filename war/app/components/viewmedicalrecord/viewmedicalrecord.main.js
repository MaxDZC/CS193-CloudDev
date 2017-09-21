var viewmedicalrecord = require('html-loader!./viewmedicalrecord.html');

angular.module('hplus.modules.viewmedicalrecord', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/doctor/view/record',{
        template: viewmedicalrecord
      })
  });
  require('./viewmedicalrecord.filter.js');  
  require('./viewmedicalrecord.directive.js');
  require('./viewmedicalrecord.controller.js');
