angular.module('hplus.modules.navbar')

  .controller('NavBarController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );