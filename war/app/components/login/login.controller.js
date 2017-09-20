angular.module('hplus.modules.login')

  .controller('LoginController',
    function($scope, globalFactory, doctorFactory, $location){

      var user = doctorFactory.getUser();
      console.log(user);

      if(user != null){
        if(user.admin){
          $location.path("/admin/list/disease");
        } else {
          $location.path("/admin/list/record");
        }
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.loginDoctor = function(){
        doctorFactory.login($scope.username, $scope.password);
      };
    }
  );