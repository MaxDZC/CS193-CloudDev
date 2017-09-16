angular.module('hplus.modules.login')

  .controller('LoginController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
       $scope.loginDoctor = function(){
        globalFactory.login($scope.username, $scope.password);
      }
    }
  );