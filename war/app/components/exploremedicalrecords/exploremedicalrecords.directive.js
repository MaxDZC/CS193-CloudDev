var card = require('html-loader!./xxcard.html');
angular.module('hplus.modules.exploremedicalrecords')

  .directive('hplusExploreMedicalRecordsCard', function(){
    return{
      restrict: 'EA',
      scope: {
        data: '='
      },
      template: card
    };
  })