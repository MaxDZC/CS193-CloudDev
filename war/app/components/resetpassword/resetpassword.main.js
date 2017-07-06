var resetpassword = require('html-loader!./resetpassword.html');

angular.module('hplus.modules.resetpassword', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/admin/reset/password',{
        template: resetpassword
      })
  });
