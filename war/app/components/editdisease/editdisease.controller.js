angular.module('hplus.modules.editdisease')

  .controller('EditDiseaseController',
    function($location, $scope, globalFactory, doctorFactory, diseaseFactory, symptomFactory, medicineFactory, modalFactory){
      
      var user = doctorFactory.getUser();
      $scope.disease = diseaseFactory.getDisease();
      console.log($scope.disease);

      if(user != null){
        if(!user.admin){
          $location.path("/admin/list/record");
        }
      } else {
        $location.path("/");
      }
      
      $scope.symptomsSelected = [];
      $scope.medicinesSelected = [];
      $scope.showAdd = false;

      $scope.go = function(path){
        globalFactory.go(path);
      };

      $scope.checkStatus = function(status) {
        var retValue = "edit-button";

        if(status){
          retValue = "edit-button";
        } else {
          retValue = "delete-button";
        }

        return retValue;
      };

      $scope.saveSymptom = function(){
        var data = {"name":$scope.addSymptom};
        symptomFactory.registerSymptom(data);
      };

      $scope.$on("repopulateUpdate", function(event){
        $scope.showAdd = !$scope.showAdd;
        $scope.addSymptom = "";

        symptomFactory.getListOfSymptoms().then(function(response){
          $scope.symptomList = response.data.symptoms;
          $scope.symptomList.forEach(function(med){
            med.val = false;
          });

          populate();
        });

      });

      $scope.saveArraySymp = function(){
        angular.forEach($scope.option, function(option){
          if (option.val){
            var data= {
                id: option.id,
                sympname: option.name
            }
            $scope.symptomsSelected.push(data);
          } 
        });
        console.log($scope.symptomsSelected);
      };

      $scope.saveArrayMedicine = function(){
        angular.forEach($scope.optionmed, function(option){
          if (option.val) {
             var data1= {
                id: option.id,
                medname: option.name
            }
            $scope.medicineSelected.push(data1);
          }
        });
        console.log($scope.medicineSelected);
      };
      
      var updateConfirmDisease = function(){
        console.log($scope.disease);

        diseaseFactory.updateDisease($scope.disease);
        
        $scope.disease = {
                "name" : "",
                "symptomId" : [],
                "medicineId" : []
        };
        
        $scope.searchFilterSymp = "";
        setVals($scope.symptomList, false);
        setVals($scope.medicineList, false);
      };

      $scope.updateDisease = function(){
        var modalObject = {
          type: "confirm",
          title: "Confirm Update",
          description: "Are you sure you want to update this disease?",
          negativeButton: "No",
          positiveButton: "Yes",
          isVisible: true,
          data: updateConfirmDisease
        };

        modalFactory.setContents(modalObject);
      };

      var populate = function(){
        symptomFactory.getListOfSymptoms().then(function(response){
          $scope.symptomList = response.data.symptoms;
          $scope.symptomList.forEach(function(med){
            if($scope.disease.symptomId.indexOf(med.id) == -1){
              med.val = false;
            } else {
              med.val = true;
            }
          });
        });
        medicineFactory.getListOfMedicines().then(function(response){
          $scope.medicineList = response.data.medicines;
          $scope.medicineList.forEach(function(med){
            if($scope.disease.medicineId.indexOf(med.id) == -1){
              med.val = false;
            } else {
              med.val = true;
            }
          });
        });
      };

      populate();

      var setVals = function (a, v) {
        var i, n = a.length;
        for (i = 0; i < n; ++i) {
          a[i].val = v;
        }
    	};
      
      $scope.addRemoveSymptom = function(hold){
    	  $scope.disease.symptomId = hold;
      };
    
      $scope.addRemoveMedicine = function(hold){
    	  $scope.disease.medicineId = hold;
      };

      $scope.delete = function() {
        diseaseFactory.deleteDisease($scope.disease);
      }
    }
  );
  