var header = require('html-loader!./header.html');
angular.module('hplus.modules.header')

  .directive('hplusHeader', function(){
    return{
      restrict: 'EA',
      template: header
    };
  })