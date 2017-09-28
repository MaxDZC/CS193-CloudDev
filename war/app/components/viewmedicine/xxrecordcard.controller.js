angular.module('hplus.modules.viewmedicine')

  .controller('RecordCardController',
    function($scope, $location, globalFactory, doctorFactory, medicalRecordFactory){
      
      $scope.user = doctorFactory.getUser();

      $scope.go = function(path, medicalRecord){
        medicalRecordFactory.saveMedicalRecord(medicalRecord);
        globalFactory.go(path);
      };

  });