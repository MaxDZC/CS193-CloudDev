require("../assets/main.scss");

require('angular');
require('angular-route');
require('./app.module.js')
require('./shared/parts/modal/newFile.js');
require('./shared/parts/modal/SweetAlert.min.js');
//require('./shared/parts/modal/sweet-alert.min.js');

var app = angular.module('hplus', [
  'ngRoute',
  'hplus.modules',
  'oitozero.ngSweetAlert']);

app.config(function ($routeProvider){  
  $routeProvider    
    .otherwise({
      redirectTo: '/'
    });  
});
