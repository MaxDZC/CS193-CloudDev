angular.module('hplus.modules.viewdisease')

  .controller('ViewDiseaseController',
    function($scope, $location, globalFactory, doctorFactory){

      var user = doctorFactory.getUser();
      console.log(user);

      if(user == null) {
        $location.path("/");
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );