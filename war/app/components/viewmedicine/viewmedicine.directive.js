var card = require('html-loader!./xxrecordcard.html');
angular.module('hplus.modules.viewmedicine')

  .directive('hplusViewMedicineCard', function(){
    return{
      restrict: 'EA',
      scope: {
        data: '='
      },
      template: card
    };
  })