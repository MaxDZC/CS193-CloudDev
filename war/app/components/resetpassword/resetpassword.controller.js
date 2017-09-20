angular.module('hplus.modules.resetpassword')

  .controller('ResetPasswordController',
    function($scope, globalFactory, doctorFactory){

      var user = doctorFactory.getUser();
      console.log(user);

      $scope.go = function(path){
        globalFactory.go(path);
      };

    }
  );