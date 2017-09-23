angular.module('hplus.modules.registerdiseases')

  .controller('RegisterDiseasesController',
    function($scope, $location, globalFactory, doctorFactory, symptomFactory, medicineFactory, diseaseFactory){
	 
      var user = doctorFactory.getUser();

      if(user != null) {
        if(!user.admin){
          $location.path("/admin/list/record");
        }
      } else {
        $location.path("/");
      }

      $scope.disease = 
      {
        "name" : "",
        "symptomId" : [],
        "medicineId" : []
      };
      
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
      
      $scope.showAdd = false;
      
      $scope.saveSymptom = function(){
        var data = {"name":$scope.addSymptom};
        symptomFactory.registerSymptom(data);
      };

      $scope.$on("repopulate", function(event){
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
      
      $scope.saveDisease = function(){
        console.log("meds");
        console.log($scope.disease.medicineId);
        console.log($scope.disease.symptomId);
        console.log($scope.disease.name);
        
        diseaseFactory.registerDisease($scope.disease);
        
        $scope.disease = {
                "name" : "",
                "symptomId" : [],
                "medicineId" : []
        };
        
        $scope.searchFilterSymp = "";
        setVals($scope.symptomList, false);
        setVals($scope.medicineList, false);
      };
      
      $scope.addRemoveSymptom = function(hold){
    	  $scope.disease.symptomId = hold;
      };
    
      $scope.addRemoveMedicine = function(hold){
    	  $scope.disease.medicineId = hold;
      };
      
      var populate = function(){
            symptomFactory.getListOfSymptoms().then(function(response){
              console.log(response);
        	    $scope.symptomList = response.data.symptoms;
        	    $scope.symptomList.forEach(function(med){
                med.val = false;
              });
            });
            medicineFactory.getListOfMedicines().then(function(response){
              $scope.medicineList = response.data.medicines;
              $scope.medicineList.forEach(function(med){
                med.val = false;
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
      
    }
  );