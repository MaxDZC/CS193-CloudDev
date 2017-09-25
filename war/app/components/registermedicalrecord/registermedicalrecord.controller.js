angular.module('hplus.modules.registermedicalrecord')

  .controller('RegisterMedicalRecordController',
    function($scope, $location, globalFactory, doctorFactory, symptomFactory, medicineFactory, diseaseFactory, patientFactory, medicalRecordFactory){

      $scope.user = doctorFactory.getUser();
      console.log($scope.user);
      if($scope.user != null) {
        if($scope.user.admin){
          $location.path("/admin/list/record");
        }
      } else {
        $location.path("/");
      }
      
      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.searchFilter = "";
      
      $scope.setSelected = function(pat){
        $scope.selectedPatient = pat;
      };
      
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
        patientFactory.getListOfPatients().then(function(response){
          console.log(response);
          $scope.patients = response.data.patients;
          if($scope.newPatient != null && $scope.newPatient.id == null){
            $scope.newPatient.firstname = toTitleCase($scope.newPatient.firstname);
            $scope.newPatient.lastname = toTitleCase($scope.newPatient.lastname);
            $scope.newPatient.address = toTitleCase($scope.newPatient.address);
            console.log("New Patient exists "+ $scope.newPatient.firstname + " "+$scope.newPatient.lastname);
            $scope.patients.forEach(function(pat){
              if(pat.lastname == $scope.newPatient.lastname &&
                 pat.firstname == $scope.newPatient.firstname &&
                 pat.address == $scope.newPatient.address &&
                 pat.sex == !$scope.newPatient.sex){
                console.log("New Patient found "+ pat.firstname);
                pat.newPatient = true;
              }
            });
          }
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
	  };
	  
	  $scope.addRemoveDisease = function(hold){
        $scope.medicalRecord.diseaseIdList = hold;
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
      
      $scope.diseaseList = [];

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