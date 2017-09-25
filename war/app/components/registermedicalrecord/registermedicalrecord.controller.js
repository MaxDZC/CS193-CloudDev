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
        $scope.medicalRecord.patient = $scope.selectedPatient.id;
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
      
      
      
      
      

	  $scope.medicalRecord = {
	    "patient" : "",
	    "symptomId" : [],
	    "diseaseId" : [],
	    "medicineId" : [],
	    "quantityList" : [],
        "totalCost" : 0
	  };
	  
	  $scope.patientType = [
        {"name" : "Inpatient", "val" : true},
        {"name" : "Outpatient", "val" : false}
      ];
	  
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

      $scope.delete = function(doctor){
        doctorFactory.deleteDoctor(doctor);
      };
      
      $scope.saveMedRec = function(){
        alert("test");
        var medHold =[];
        var symHold =[];
        var disHold =[];
        $scope.medicalRecord.quantityList = [];
        
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
        
        //alert($scope.medicalRecord);
        //registerMedRec
      };
      
      $scope.checkStatus = function(status){
        return (status) ? "edit-button" : "delete-button";
      };
      
      
    }
  );