angular.module('hplus.modules.explorepatients')

  .controller('PatientCardController',
    function($scope, globalFactory, patientFactory){

      $scope.go = function(path, patient){
        patientFactory.savePatient(patient);
        globalFactory.go(path);
      };

      $scope.delete = function(patient){
        patientFactory.deletePatient(patient);
      };
    }
  );