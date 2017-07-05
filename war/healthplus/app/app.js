require("../assets/main.scss");

require('angular');
require('angular-route');
require('./app.module.js')

var app = angular.module('hplus', [
  'ngRoute',
  'hplus.modules']);

app.config(function ($routeProvider){  
  $routeProvider    
    .otherwise({
      redirectTo: '/'
    });  
});
