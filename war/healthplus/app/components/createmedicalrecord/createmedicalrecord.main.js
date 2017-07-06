var createmedicalrecord = require('html-loader!./createmedicalrecord.html');

angular.module('hplus.modules.createmedicalrecord', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/doctor/create/record',{
        template: createmedicalrecord
      })
  });
