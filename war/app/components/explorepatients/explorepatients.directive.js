var card = require('html-loader!./xxpatientcard.html');

angular.module('hplus.modules.explorepatients')

  .directive('hplusExplorePatientsCard', function(){
    return{
      restrict: 'EA',
      scope: {
        data: '='
      },
      template: card
    };
  })