angular.module('hplus.modules.header')

  .controller('HeaderController',
    function($scope, globalFactory, doctorFactory){

      $scope.user = doctorFactory.getUser();
      console.log($scope.user);

      $scope.$on("userLoggedIn", function(event, user) {
        $scope.user = user;
      });

      $scope.logout = function(){
        doctorFactory.logout();
        $scope.user = null;
      };

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );