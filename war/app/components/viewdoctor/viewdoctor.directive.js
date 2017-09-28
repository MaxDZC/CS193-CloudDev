var card = require('html-loader!./xxrecordcard.html');
angular.module('hplus.modules.viewdoctor')

  .directive('hplusViewDoctorsCard', function(){
    return{
      restrict: 'EA',
      scope: {
        data: '='
      },
      template: card
    };
  })