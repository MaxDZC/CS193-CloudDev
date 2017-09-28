angular.module('hplus.modules.viewdoctor')

  .controller('DoctorRecordCardController',
    function($scope, $location, globalFactory, medicalRecordFactory){
      
      $scope.go = function(path, medicalRecord){
        medicalRecordFactory.saveMedicalRecord(medicalRecord);
        globalFactory.go(path);
      };

  });