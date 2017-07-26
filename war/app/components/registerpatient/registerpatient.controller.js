angular.module('hplus.modules.registerpatient')

  .controller('RegisterPatientController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );
