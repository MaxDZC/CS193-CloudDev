angular.module('hplus.modules.editmedicalrecord')

  .controller('EditMedicalRecordController',
    function($scope, $location, globalFactory, doctorFactory, symptomFactory, medicineFactory, diseaseFactory, patientFactory, medicalRecordFactory){
	  
      $scope.user = doctorFactory.getUser();
      console.log($scope.user);
//      if($scope.user != null) {
//        if($scope.user.admin){
//          $location.path("/admin/list/record");
//        }
//      } else {
//        $location.path("/");
//      }
      
      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.searchFilter = "";
      
      
      $scope.selectedPatient = patientFactory.getPatient();
      
      $scope.patients=[];
      
      $scope.initComponents = function(){
    	  $scope.medicalRecord.firstName = "";
    	  $scope.medicalRecord.lastName = "";
    	  $scope.medicalRecord.birthday = "";
    	  $scope.medicalRecord.sex = "";
    	  $scope.medicalRecord.admissionDate = "";
    	  $scope.medicalRecord.disease = "";
    	  
    	  for(var i=0; i < $scope.medicalRecord.symptomIdList.length; i++){
    		  $scope.medicalRecord.symptomIdList[i] = false;
    	  }
    	  
    	  for(var i=0; i < $scope.medicalRecord.medicineIdList.length; i++){
    		  $scope.medicalRecord.medicineIdList[i] = false;
    	  }
      };
      
      $scope.newPatient = patientFactory.getPatient();
      
      var toTitleCase = function(str){
          return str.replace(/\w\S*/g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();});
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
      
      
      
      
      

	  $scope.medicalRecord = {
	    "symptomIdList" : [],
	    "diseaseIdList" : [],
	    "medicineIdList" : [],
	    "quantityList" : [],
        "totalCost" : 0
	  };
	  
	  $scope.patientType = [
        {"name" : "Inpatient", "val" : true},
        {"name" : "Outpatient", "val" : false}
      ];
	  

	  $scope.addRemoveSymptom = function(hold){
        $scope.medicalRecord.symptomIdList = hold;
        
        $scope.diseaseListFiltered = [];
        if(hold.length > 0){
          var i,j;
          $scope.diseaseList.forEach(function(dis){
            dis.symptomId.sort();
            for(i=j=0; i < hold.length && j < dis.symptomId.length;){
              if(hold[i].id == dis.symptomId[j]){
                i++; j++;
              }else if((hold[i].id > dis.symptomId[j])){
                j++;
              }else{
                break;
              }
            }
            if(i == hold.length){
              $scope.diseaseListFiltered.push(dis);  
            }
            
          });
        }
        
	  };
	  
	  $scope.addRemoveDisease = function(hold){
        $scope.medicalRecord.diseaseIdList = hold;
        
        $scope.medicineListFiltered = [];
        if(hold.length > 0){
          var i,j;
          $scope.medicineList.forEach(function(med){
            for(i = 0; i < hold.length; i++){
              hold[i].medicineId.sort();
              for(j = 0; j < hold[i].medicineId.length && med.id < hold[i].medicineId[j] ; j++){}
              if(med.id == hold[i].medicineId[j]){
                break;
              }
            }
            if(i < hold.length){
              $scope.medicineListFiltered.push(med);  
            }
            
          });
        }
	  };
	  
	  
	  $scope.addRemoveMedicine = function(hold){
        $scope.medicalRecord.medicineIdList = hold;
	  };
	  
	  $scope.calculateTotal = function(){
        $scope.medicalRecord.totalCost = 0;
        $scope.medicalRecord.medicineIdList.forEach(function(med){
          $scope.medicalRecord.totalCost += (med.price * med.quantity);
        });
	  };
	  
	  $scope.symptomList = [];
      
      $scope.medicineList = [];
      $scope.medicineListFiltered = [];
      
      $scope.diseaseList = [];
      $scope.diseaseListFiltered = [];

      $scope.delete = function(doctor){
        doctorFactory.deleteDoctor(doctor);
      };
      
      $scope.saveMedRec = function(){
        var medHold =[];
        var symHold =[];
        var disHold =[];
        $scope.medicalRecord.patientId = $scope.selectedPatient.id;
        $scope.medicalRecord.doctorId = $scope.user.id;
        $scope.medicalRecord.quantityList = [];
        
        $scope.medicalRecord.medicineIdList.forEach(function(med){
          $scope.medicalRecord.quantityList.push(med.quantity);
          medHold.push(med.id);
        });
        $scope.medicalRecord.symptomIdList.forEach(function(sym){
          symHold.push(sym.id);
        });
        $scope.medicalRecord.diseaseIdList.forEach(function(dis){
          disHold.push(dis.id);
        });
        
        $scope.medicalRecord.medicineIdList = medHold;
        $scope.medicalRecord.symptomIdList = symHold;
        $scope.medicalRecord.diseaseIdList = disHold;
        
        //alert($scope.medicalRecord);
        //registerMedRec
        medicalRecordFactory.createMedicalRecord($scope.medicalRecord, $scope.initComponents).then(function(){
          patientFactory.savePatient(null);
          $scope.newPatient = patientFactory.getPatient();
          $scope.selectedPatient = null;
          $scope.medicalRecord = {
    	    "symptomIdList" : [],
    	    "diseaseIdList" : [],
    	    "medicineIdList" : [],
    	    "quantityList" : [],
            "totalCost" : 0
          };
          populate();
        },function(){});
      };
      
      $scope.checkStatus = function(status){
        return (status) ? "edit-button" : "delete-button";
      };
      
      
    }
  );