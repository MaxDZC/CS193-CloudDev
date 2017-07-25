var registerpatient = require('html-loader!./registerpatient.html');

angular.module('hplus.modules.registerpatient', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/admin/register/patient',{
        template: registerpatient
      })
  });

  require('./registerpatient.controller.js');