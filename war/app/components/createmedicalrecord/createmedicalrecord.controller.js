angular.module('hplus.modules.createmedicalrecord')

  .controller('CreateMedicalRecordController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );