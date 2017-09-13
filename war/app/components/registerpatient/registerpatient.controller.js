angular.module('hplus.modules.registerpatient')

  .controller('RegisterPatientController',
    function($scope, globalFactory, patientFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
	  
	$scope.registerPatient = function(){
        patientFactory.registerPatient($scope.patient);
    };
	  
    }
  );
