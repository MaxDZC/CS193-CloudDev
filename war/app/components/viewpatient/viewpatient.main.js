var viewdoctor = require('html-loader!./viewpatient.html');

angular.module('hplus.modules.viewpatient', [])

  .config(function ($routeProvider){  
    $routeProvider      
      .when('/patient/view/details',{
        template: viewdoctor
      })
  });
