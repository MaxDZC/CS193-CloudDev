angular.module('hplus.modules.registermedicalrecord')

  .controller('DetailsCardController',
    function($scope, $location, globalFactory, doctorFactory){
      
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
          "name" : "DISISIT"
        },
        {
          "name" : "PRITITIT"
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
	  

      $scope.medicalRecord = {};
      
      $scope.medicalRecord.symptomId = [];
      
      $scope.medicalRecord.medicineId = [];
      
      
      
      $scope.go = function(path){
        globalFactory.go(path);
      };

      $scope.delete = function(doctor){
        doctorFactory.deleteDoctor(doctor);
      };
    }
  );