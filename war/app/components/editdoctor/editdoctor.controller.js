angular.module('hplus.modules.editdoctor')

  .controller('EditDoctorController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );