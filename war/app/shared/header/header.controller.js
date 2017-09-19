angular.module('hplus.modules.header')

  .controller('HeaderController',
    function($scope, globalFactory, doctorFactory){

      $scope.user = doctorFactory.getUser();
      console.log($scope.user);

      $scope.logout = function(){
        doctorFactory.logout();
      };

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );