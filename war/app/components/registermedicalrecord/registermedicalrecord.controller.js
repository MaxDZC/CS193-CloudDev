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
      
      $scope.searchFilter = "";
      
      $scope.medicalRecord = {};
      
      $scope.medicalRecord.symptomChoice = [];
      
      $scope.medicalRecord.medicineChoice = [];
      
      $scope.symptomList = ["TextHere1", "TextHere2", "TextHere3", "TextHere4" , "TextHere5"];
      
      $scope.medicineList = ["TextHere1", "TextHere2", "TextHere3", "TextHere4" , "TextHere5"];
      $scope.setSelected = function(pat){
    	  
    	  $scope.selectedPatient = pat;
      };
      $scope.patient=[
                        {
                          name : "person1",
                          date :[ "Last admitted November 1,2017"],
                          id : 1
                        },
                        {
                          name : "person2",
                          date :[" Last admitted November 8,2017"],
                          id : 2
                        },
                        {
                          name : "Mumei",
                          date :[" Last admitted November 3,2017"],
                          id : 3
                        },
                        {
                          name : "Rem",
                          date :[" Last admitted November 25,2017"],
                          id : 4
                        },
                        {
                          name : "eren",
                          date :[" Last admitted November 16,2017"],
                          id : 5
                        },
                        {
                          name : "lucy",
                          date :[" Last admitted November 1,2012"],
                          id : 6
                        },
                        {
                          name : "erza",
                          date :[" Last admitted November 12,2017"],
                          id : 7
                        },
                        {
                          name : "heyyy",
                          date :[" Last admitted November 1,2017"],
                          id : 8
                        },
                        {
                          name : "Bentompura",
                          date :[" Last admitted November 15,2012"],
                          id : 9
                        },
                        {
                          name : "PATATO FRIES",
                          date :[" Last admitted November 1,2017"],
                          id : 10
                        },
                        {
                          name : "HAMBURGERAH",
                          date :[" Last admitted November 30,2011"],
                          id : 11
                        }
                      ];
                
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