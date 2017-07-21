angular.module('hplus.modules.registerdoctor')

  .controller('RegisterDoctorController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );