angular.module('hplus.modules.registermedicalrecord')

  .controller('DetailsCardController',
    function($scope, $location, globalFactory, doctorFactory, symptomFactory, medicineFactory, diseaseFactory	){
      
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
	  
	  $scope.populate = function(data){
        if(data != null){
          $scope.medicalRecord.patient = data.id;
        }
	  };
	  
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
      
      $scope.go = function(path){
        globalFactory.go(path);
      };

      $scope.delete = function(doctor){
        doctorFactory.deleteDoctor(doctor);
      };
      
      $scope.saveMedRec = function(){
        alert("test");
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
        
        alert($scope.medicalRecord);
        //registerMedRec
      };
      
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
      
      $scope.checkStatus = function(status){
        return (status) ? "edit-button" : "delete-button";
      };
    }
  );