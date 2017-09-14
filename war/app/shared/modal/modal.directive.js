var modal = require('html-loader!./modal.html');
angular.module('hplus.modules.modal')

  .directive('hplusModal', function(){
    return{
      restrict: 'EA',
      template: modal
    };
  })