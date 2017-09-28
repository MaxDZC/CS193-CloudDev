angular.module('hplus.modules.login')

  .controller('LoginController',
    function($scope, globalFactory, doctorFactory, $location){

      var user = doctorFactory.getUser();
      console.log(user);

      if(user != null){
        $location.path("/admin/list/record");
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.loginDoctor = function(){
        doctorFactory.login($scope.username, $scope.password);
      };
    }
  );