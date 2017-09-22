angular.module('hplus.modules.registerdiseases')

  .controller('RegisterDiseasesController',
    function($scope, $location, globalFactory, doctorFactory, symptomFactory, medicineFactory, diseaseFactory){
	 
      var user = doctorFactory.getUser();
      console.log(user);

      if(user != null) {
        if(!user.admin){
          $location.path("/admin/list/record");
        }
      } else {
        $location.path("/");
      }
      
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
        symptomFactory.getListOfSymptoms().then(function(response){
            $scope.symptomList = response.data.symptoms;
            $scope.symptomList.forEach(function(med){
              med.val = false;
            });
          },function(){});
      }
      
      $scope.saveDisease = function(){
        console.log($scope.disease.medicineId);
        console.log($scope.disease.symptomId);
        console.log($scope.disease.name);
        diseaseFactory.registerDisease($scope.disease);
        $scope.disease = {
                "name" : "",
                "symptomId" : [],
                "medicineId" : []
              };
              
        setVals($scope.symptomList,false);
       setVals($scope.medicineList,false);
      }
      
      $scope.addRemoveSymptom = function(hold){
    	  $scope.disease.symptomId= hold;
      }
      
      $scope.symptomList = [
        {
          name: "Examples",
          id: 1,
          val:false
        },
        {
          name: "of",
          id: 2,
          val:false
        },
        {
          name: "Symptoms",
          id: 3,
          val:false
        },
        {
          name: "wooh",
          id: 4,
          val:false
        },
        {
          name: "hahaha",
          id: 5,
          val:false
        },
        {
          name: "BoBurnham",
          id: 6,
          val:false
        }
      ];
      
//                                 
//      $scope.addMedicine = function(hold){
//        $scope.medicinesSelected.push(hold);
//        $scope.medicinesSearch.splice($scope.medicinesSearch.indexOf(hold),1);
//      };
//                                 
//      $scope.removeMedicine = function(hold){
//        $scope.medicinesSearch.push(hold);
//        $scope.medicinesSelected.splice($scope.medicinesSelected.indexOf(hold),1);
//      };
//      
      $scope.addRemoveMedicine = function(hold){
    	  $scope.disease.medicineId= hold;
      }
      
      $scope.medicineList = [
                         {
                           name: "Metformin",
                           id: 1,
                           val:false
                         },
                         {
                           name: "Meth",
                           id: 2,
                           val:false
                         },
                         {
                           name: "Methamphetamine",
                           id: 3,
                           val:false
                         },
                         {
                           name: "Methazolamide",
                           id: 4,
                           val:false
                         },
                         {
                           name: "Methazolamide",
                           id: 5,
                           val:false
                         },
                         {
                           name: "Meth",
                           id: 6,
                           val:false
                         },
                         {
                           name: "Methenamine",
                           id: 7,
                           val:false
                         },
                         {
                           name: "Methimazole",
                           id: 8,
                           val:false
                         },
                         {
                           name: "Meth",
                           id: 9,
                           val:false
                         }
                       ];
      
      $scope.disease = 
      {
        "name" : "",
        "symptomId" : [],
        "medicineId" : []
      };
      
      var populate = function(){
            symptomFactory.getListOfSymptoms().then(function(response){
        	  $scope.symptomList = response.data.symptoms;
        	  $scope.symptomList.forEach(function(med){
                med.val = false;
              });
            },function(){});
            medicineFactory.getListOfMedicines().then(function(response){
              $scope.medicineList = response.data.medicines;
              $scope.medicineList.forEach(function(med){
                med.val = false;
              });
            },function(){});
      };
      populate();
      
      var setVals = function (a, v) {
    	    var i, n = a.length;
    	    for (i = 0; i < n; ++i) {
    	        a[i].val = v;
    	    }
    	}
      
    }
  );