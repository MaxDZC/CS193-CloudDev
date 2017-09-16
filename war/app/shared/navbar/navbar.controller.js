angular.module('hplus.modules.navbar')

  .controller('NavbarController',
    function($scope, $location, globalFactory){

      $scope.registerButton = "Register Disease";

      $scope.checkPage = function(){
        var state = true;

        if($location.path() == "/admin/register/doctor"){
          state = false;
        }

        return state;
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );