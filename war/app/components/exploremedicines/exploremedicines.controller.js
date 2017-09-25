angular.module('hplus.modules.exploremedicines')

  .controller('ExploreMedicinesController',
    function($scope, $location, globalFactory, doctorFactory, medicineFactory, diseaseFactory){
	  
      $scope.selectedMedicine = null;
      $scope.query = "";
      $scope.diseaseList = [];

      $scope.user = doctorFactory.getUser();

      if($scope.user == null){
        $location.path("/");
      }

      $scope.searchFilter = function(medicine){
        if(!$scope.query 
        || (medicine.name.toLowerCase().indexOf($scope.query) != -1)){
          return true;
        } else {
          return false;
        }
      };
      
      var populate = function(){
        medicineFactory.getListOfMedicines().then(function(response){
          console.log(response);
          $scope.medicineList = response.data.medicines;
          var medicalRecords = response.data.medicalRecords;

          var x, y, z;
          
          for(x = 0; x < $scope.medicineList.length; x++) {
            for(y = 0; y < medicalRecords.length; y++) {
              for(z = 0; z < medicalRecords[y].medicineIdList.length; z++) {
                if(medicalRecords[y].medicineIdList[z] == $scope.medicineList[x].id) {
                  if($scope.medicineList[x].medicalRecords == null) {
                    $scope.medicineList[x].medicalRecords = [];
                  }
                  $scope.medicineList[x].medicalRecords.push(medicalRecords[y]);
                  z = medicalRecords[y].medicineIdList.length;
                }
              } 
            }
          }
          
          diseaseFactory.getListOfDiseases().then(function(response){
            console.log(response);
            $scope.diseaseList = response.data.diseases;
            var x, y, treats, name;

            for(x = 0; x < $scope.medicineList.length; x++){
              treats = [];
              for(y = 0; y < $scope.diseaseList.length; y++){
                if($scope.diseaseList[y].medicineId.indexOf($scope.medicineList[x].id) != -1){
                  name = $scope.diseaseList[y].name;
                  treats.push(name[0].toUpperCase() + name.substr(1));
                }
              }
              if(treats.length == 0){
                treats.push("Nothing");
              }
              $scope.medicineList[x].treats = treats;
            }
            

          });

        }, function(response){
          console.log(response);
        });
      };

      populate();

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      
      $scope.setSelected = function(med){
    	  $scope.selectedMedicine = med;
      };
    }
  );