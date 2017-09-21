var card = require('html-loader!./xxrecordcard.html');
angular.module('hplus.modules.viewpatient')

  .directive('hplusViewPatientCard', function(){
    return{
      restrict: 'EA',
      scope: {
        data: '='
      },
      template: card
    };
  })