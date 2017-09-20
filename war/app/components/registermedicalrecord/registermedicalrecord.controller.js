angular.module('hplus.modules.registermedicalrecord')

  .controller('RegisterMedicalRecordController',
    function($scope, $location, globalFactory, medicalRecordFactory, doctorFactory){

      var user = doctorFactory.getUser();

      if(user != null) {
        if(user.admin){
          $location.path("/admin/list/record");
        }
      } else {
        $location.path("/");
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.medicalRecord = {};
      
      $scope.medicalRecord.symptomChoice = [];
      
      $scope.medicalRecord.medicineChoice = [];
      
      $scope.symptomList = ["TextHere1", "TextHere2", "TextHere3", "TextHere4" , "TextHere5"];
      
      $scope.medicineList = ["TextHere1", "TextHere2", "TextHere3", "TextHere4" , "TextHere5"];
      
      $scope.createMedicalRecord = function(){
    	  medicalRecordFactory.createMedicalRecord($scope.medicalRecord, $scope.initComponents);
      }
      
      $scope.initComponents = function(){
    	  $scope.medicalRecord.firstName = "";
    	  $scope.medicalRecord.lastName = "";
    	  $scope.medicalRecord.birthday = "";
    	  $scope.medicalRecord.sex = "";
    	  $scope.medicalRecord.admissionDate = "";
    	  $scope.medicalRecord.disease = "";
    	  
    	  for(var i=0; i < $scope.medicalRecord.symptomChoice.length; i++){
    		  $scope.medicalRecord.symptomChoice[i] = false;
    	  }
    	  
    	  for(var i=0; i < $scope.medicalRecord.medicineChoice.length; i++){
    		  $scope.medicalRecord.medicineChoice[i] = false;
    	  }
      }
    }
  );