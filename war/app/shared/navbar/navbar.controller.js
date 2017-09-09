angular.module('hplus.modules.navbar')

  .controller('NavbarController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );