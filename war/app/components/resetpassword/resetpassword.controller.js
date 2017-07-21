angular.module('hplus.modules.resetpassword')

  .controller('ResetPasswordController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );