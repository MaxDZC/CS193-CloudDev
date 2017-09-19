angular.module('hplus.modules.login')

  .controller('LoginController',
    function($scope, globalFactory, doctorFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.loginDoctor = function(){
        doctorFactory.login($scope.username, $scope.password);
      };
    }
  );