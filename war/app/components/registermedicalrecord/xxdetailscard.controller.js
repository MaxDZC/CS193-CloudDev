angular.module('hplus.modules.registermedicalrecord')

  .controller('DetailsCardController',
    function($scope, $location, globalFactory, doctorFactory){
      
	  $scope.medicalRecord = {
	    "patient" : "",
	    "symptomId" : {},
	    "diseaseId" : {},
	    "medicineId" : {},
        "type" : "",
        "totalCost" : 0
	  };
	  
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
	  
	  $scope.symptomList = [ 
        {
          "name" : "DISISIT"
        },
        {
          "name" : "PRITITIT"
        }
      ];
      
      $scope.medicineList = [ 
        {
          "name" : "DISISIT",
          "price" : 123
        },
        {
          "name" : "PRITITIT",
          "price" : 25
        }
      ];
      
      $scope.diseaseList = [ 
      {
        "name" : "DISISIT"
      },
      {
        "name" : "PRITITIT"
      },
      {
        "name" : "DISISIT"
      },
      {
        "name" : "PRITITIT"
      },
      {
        "name" : "DISISIT"
      },
      {
        "name" : "PRITITIT"
      },
      {
        "name" : "DISISIT"
      },
      {
        "name" : "PRITITIT"
      }
      ];
      
      $scope.go = function(path){
        globalFactory.go(path);
      };

      $scope.delete = function(doctor){
        doctorFactory.deleteDoctor(doctor);
      };
      
      $scope.saveMedRec = function(){
        alert("test");
        //saveMedRec
      };
    }
  );