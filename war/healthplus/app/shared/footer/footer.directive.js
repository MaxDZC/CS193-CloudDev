var footer = require('html-loader!./footer.html');
angular.module('hplus.modules.footer')

  .directive('hplusFooter', function(){
    return{
      restrict: 'EA',
      template: footer
    };
  })