var userLogin = require('html-loader!./loginForm.html');

angular.module('hplus.modules.userLogin', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/user/login',{
        template: userLogin
      })
  });
