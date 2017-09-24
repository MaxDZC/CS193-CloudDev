var card = require('html-loader!./xxcard.html');
var scard = require('html-loader!./xxdetailsCard.html');
angular.module('hplus.modules.registermedicalrecord')

  .directive('hplusRegisterMedicalRecordCard', function(){
    return{
      restrict: 'EA',
      scope: {
        data: '='
      },
      template: card
    };
  })
  
  .directive('hplusSelectedPatientCard', function(){
    return{
      restrict: 'EA',
      scope: {
        data: '='
      },
      template: scard
    };
  })