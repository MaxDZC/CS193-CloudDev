angular.module('hplus.modules.viewmedicine')

  .controller('RecordCardController',
    function($scope, $location, globalFactory, medicalRecordFactory){
      
      $scope.go = function(path, medicalRecord){
        medicalRecordFactory.saveMedicalRecord(medicalRecord);
        globalFactory.go(path);
      };

  });