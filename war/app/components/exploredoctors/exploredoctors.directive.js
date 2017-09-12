var card = require('html-loader!../../shared/parts/data/xxcard.html');
angular.module('hplus.modules.exploredoctors')

  .directive('hplusExploreDoctorsCard', function(){
    return{
      restrict: 'EA',
      scope: {
        data: '='
      },
      template: card
    };
  })