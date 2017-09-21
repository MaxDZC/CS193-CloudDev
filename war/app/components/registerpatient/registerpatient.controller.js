angular.module('hplus.modules.registerpatient')

  .controller('RegisterPatientController',
    function($scope, $location, globalFactory, patientFactory, doctorFactory){

      var user = doctorFactory.getUser();
      console.log(user);

      if(user == null) {
        $location.path("/");
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };
	  
	    $scope.registerPatient = function(){
        patientFactory.registerPatient($scope.patient);
      };
	  
    }
  );
