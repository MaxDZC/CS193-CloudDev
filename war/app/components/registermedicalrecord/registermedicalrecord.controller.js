angular.module('hplus.modules.registermedicalrecord')

  .controller('RegisterMedicalRecordController',
    function($scope, $location, globalFactory, doctorFactory, symptomFactory, medicineFactory, diseaseFactory, patientFactory){

      $scope.user = doctorFactory.getUser();

//      if($scope.user != null) {
//        if(user.admin){
//          $location.path("/admin/list/record");
//        }
//      } else {
//        $location.path("/");
//      }

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.searchFilter = "";
      
      $scope.setSelected = function(pat){
        $scope.selectedPatient = pat;
      };
      $scope.patients=[];
                
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
      };
      
      var populate = function(){
        patientFactory.getListOfPatients().then(function(response){
          console.log(response);
          $scope.patients = response.data.patients;
        }, function(response){
          console.log(response);
        });
      };

      populate();
    }
  );