var card = require('html-loader!./xxcard.html');
var scard = require('html-loader!./xxselectedCard.html');
angular.module('hplus.modules.exploremedicines')

  .directive('hplusExploreMedicinesCard', function(){
    return{
      restrict: 'EA',
      scope: {
        data: '=',
        selectedMed: '='
      },
      template: card
    };
  })
  
  .directive('hplusSelectedMedicineCard', function(){
    return{
      restrict: 'EA',
      scope: {
        data: '='
      },
      template: scard
    };
  })