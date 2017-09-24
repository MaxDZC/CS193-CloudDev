angular.module('hplus.modules.registerpatient')

  .controller('RegisterPatientController',
    function($scope, $location, globalFactory, patientFactory, doctorFactory, modalFactory){

      var user = doctorFactory.getUser();
      $scope.regex = "\\d{6,}";


      if(user == null) {
        $location.path("/");
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };

      var validity = function(){
        return ($scope.patient.birthday < new Date());;
      };

      var confirmRegisterPatient = function(){
        patientFactory.registerPatient($scope.patient);
        $scope.patient = {};
      };
	  
	    $scope.registerPatient = function(){
        var modalObject = {};

        if(validity()){
          modalObject = {
            type: "confirm",
            title: "Confirm Registration",
            description: "Are you sure you want to register " + $scope.patient.firstname + "?",
            negativeButton: "No",
            positiveButton: "Yes",
            isVisible: true,
            data: confirmRegisterPatient
          };
        } else {
          modalObject = {
            type: "notify",
            title: "Unable to register patient!",
            description: "Invalid birthday!",
            positiveButton: "Ok",
            isVisible: true
          };
        }

        modalFactory.setContents(modalObject);
      };
      
      $scope.checkStatus = function(status){
        return (status) ? "edit-button" : "delete-button";
      };
	  
    }
  );
