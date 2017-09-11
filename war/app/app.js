require("../assets/main.scss");

require('angular');
require('angular-route');
require('./app.module.js');
require('angular-utils-pagination');
require('./shared/parts/modal/newFile.js');
require('./shared/parts/modal/SweetAlert.min.js');

var app = angular.module('hplus', [
                            'ngRoute',
                            'hplus.modules',
                            'oitozero.ngSweetAlert',
                            'angularUtils.directives.dirPagination'
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
