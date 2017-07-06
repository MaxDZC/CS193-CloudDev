angular.module('hplus.modules.login')

  .controller('LoginController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );