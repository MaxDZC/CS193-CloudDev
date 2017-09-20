var card = require('html-loader!./xxcard.html');
angular.module('hplus.modules.explorediseases')

  .directive('hplusExploreDiseasesCard', function(){
    return{
      restrict: 'EA',
      scope: {
        data: '='
      },
      template: card
    };
  })