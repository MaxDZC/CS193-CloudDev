var exploremedicines = require('html-loader!./exploremedicines.html');

angular.module('hplus.modules.exploremedicines', [])

  .config(function ($routeProvider){  
    $routeProvider
      .when('/admin/list/medicine',{
        template: exploremedicines
      })
  });
