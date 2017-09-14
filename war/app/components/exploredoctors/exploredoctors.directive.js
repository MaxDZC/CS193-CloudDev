var card = require('html-loader!./xxdoctorcard.html');
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