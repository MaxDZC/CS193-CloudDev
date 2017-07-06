angular.module('hplus.modules.header')

  .controller('HeaderController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );