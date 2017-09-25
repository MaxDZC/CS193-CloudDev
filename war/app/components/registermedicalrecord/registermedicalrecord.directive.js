var card = require('html-loader!./xxcard.html');
angular.module('hplus.modules.registermedicalrecord')

  .directive('hplusSelectPatientCard', function(){
    return{
      restrict: 'EA',
      scope: {
        data: '='
      },
      template: card
    };
  })