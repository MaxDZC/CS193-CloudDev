var userLogin = require('html-loader!./login.html');

angular.module('hplus.modules.login', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/',{
        template: userLogin
      })

      .when('/user/login',{
        template: userLogin
      })
  });

require('./login.controller.js');