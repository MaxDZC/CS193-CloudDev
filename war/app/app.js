require("../assets/main.scss");

require('angular');
require('angular-route');
require('zxcvbn');
require('angular-zxcvbn');
require('./app.module.js');
require('angular-utils-pagination');

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
