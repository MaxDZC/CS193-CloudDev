angular.module('hplus.modules.explorepatients')

  .controller('PatientCardController',
    function($scope, $location, globalFactory, doctorFactory, patientFactory, modalFactory){
      
      $scope.go = function(path, patient){
        patientFactory.savePatient(patient);
        globalFactory.go(path);
      };

      $scope.delete = function(patient){
        patientFactory.deletePatient(patient);
      };
    }
  );