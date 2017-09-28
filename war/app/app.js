require("../assets/main.scss");

require('angular');
require('angular-route');
var zxcvbn = require('zxcvbn');
window.zxcvbn = zxcvbn;
require('angular-zxcvbn');
require('angular-utils-pagination');

require('./app.module.js');


var app = angular.module('hplus', [
                            'ngRoute',
                            'hplus.modules',
                            'angularUtils.directives.dirPagination',
                            'zxcvbn'
                          ]
                        );


app.config(function ($routeProvider, $locationProvider, paginationTemplateProvider){  
  $routeProvider   
    .otherwise({
      redirectTo: '/'
    });  

  //$locationProvider.html5Mode(true);
    // $locationProvider.html5Mode({
    //   enabled: true,
    //   requireBase: false
    // });
  
  // Stylizes the pagination
  paginationTemplateProvider.setString(require('html-loader!./shared/parts/data/xxpagination.html'));
});
