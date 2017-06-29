var navbar = require('html-loader!./navbar.html');
angular.module('hplus.modules.navbar')

  .directive('hplusNavbar', function(){
    return{
      restrict: 'EA',
      template: navbar
    };
  })