var registerdiseases = require('html-loader!./registerdiseases.html');

angular.module('hplus.modules.registerdiseases', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/admin/register/disease',{
        template: registerdiseases
      })
  });
