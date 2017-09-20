var card = require('html-loader!./xxrecordcard.html');
angular.module('hplus.modules.viewdisease')

  .directive('hplusViewDiseaseCard', function(){
    return{
      restrict: 'EA',
      scope: {
        data: '='
      },
      template: card
    };
  })