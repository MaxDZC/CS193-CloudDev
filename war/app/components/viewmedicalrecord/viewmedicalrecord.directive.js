var card = require('html-loader!./xxcard.html');
angular.module('hplus.modules.viewmedicalrecord')

  .directive('hplusViewMedicalRecordCard', function(){
    return{
      restrict: 'EA',
      scope: {
        data: '='
      },
      template: card
    };
  })