angular.module('hplus.modules.exploredoctors')

  .controller('DoctorCardController',
    function($scope, globalFactory, doctorFactory){

      $scope.go = function(path, doctor){
        doctorFactory.saveDoctor(doctor);
        globalFactory.go(path);
      };
    }
  );