angular.module('hplus.modules.registerpatient')

  .controller('RegisterPatientController',
    function($scope, $location, globalFactory, patientFactory, doctorFactory, modalFactory, symptomFactory, diseaseFactory, medicineFactory){

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
        
        
        var medHold =[];
        var symHold =[];
        var disHold =[];
        
        $scope.medicalRecord.medicineId.forEach(function(med){
          $scope.medicalRecord.quantityList.push(med.quantity);
          medHold.push(med.id);
        });
        $scope.medicalRecord.symptomId.forEach(function(sym){
          symHold.push(sym.id);
        });
        $scope.medicalRecord.diseaseId.forEach(function(dis){
          disHold.push(dis.id);
        });
        
        $scope.medicalRecord.medicineId = medHold;
        $scope.medicalRecord.symptomId = symHold;
        $scope.medicalRecord.diseaseId = disHold;
        $scope.medicalRecord.patient;//get patient ID
        
        //dis is where u actually register the record in lol
        alert($scope.medicalRecord);
        
        $scope.patient = {};
        $scope.registerRecord = false;
  	  	$scope.medicalRecord = {
          "patient" : "",
          "symptomId" : {},
          "diseaseId" : {},
          "medicineId" : {},
          "type" : "",
          "totalCost" : 0
		};
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
	  
      $scope.registerRecord = false;
      
      $scope.medicalRecord = {
	    "patient" : "",
	    "symptomId" : {},
	    "diseaseId" : {},
	    "medicineId" : {},
        "type" : "",
        "totalCost" : 0
	  };
      
      $scope.editPatient = function(){
    	  $scope.registerRecord = false;
    	  $scope.medicalRecord = {
		    "patient" : "",
		    "symptomId" : {},
		    "diseaseId" : {},
		    "medicineId" : {},
	        "type" : "",
	        "totalCost" : 0
		  };
      }
      
      $scope.addRemoveSymptom = function(hold){
          $scope.medicalRecord.symptomId = hold;
  	  };
  	  
  	  $scope.addRemoveDisease = function(hold){
          $scope.medicalRecord.diseaseId = hold;
  	  };
  	  
  	  $scope.addRemoveMedicine = function(hold){
          $scope.medicalRecord.medicineId = hold;
  	  };
  	  
  	  $scope.calculateTotal = function(){
          $scope.medicalRecord.totalCost = 0;
          $scope.medicalRecord.medicineId.forEach(function(med){
            $scope.medicalRecord.totalCost += (med.price * med.quantity);
          });
  	  };
  	  
  	  $scope.symptomList = [];
        
      $scope.medicineList = [];
        
      $scope.diseaseList = [];

      var populate = function(){
        symptomFactory.getListOfSymptoms().then(function(response){
          console.log(response);
          $scope.symptomList = response.data.symptoms;
        });
        medicineFactory.getListOfMedicines().then(function(response){
          $scope.medicineList = response.data.medicines;
        });
        diseaseFactory.getListOfDiseases().then(function(response){
          console.log(response); 
          $scope.diseaseList = response.data.diseases;
        });
      };
      populate();
      
      $scope.createRecord = function(){
    	  $scope.registerRecord = true;
      };
      
    }
  );
