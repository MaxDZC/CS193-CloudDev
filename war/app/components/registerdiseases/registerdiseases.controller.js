angular.module('hplus.modules.registerdiseases')

  .controller('RegisterDiseasesController',
    function($scope, $location, globalFactory, doctorFactory){
      
      var user = doctorFactory.getUser();
      console.log(user);

      if(user != null) {
        if(!user.admin){
          $location.path("/admin/list/record");
        }
      } else {
        $location.path("/");
      }
      
      $scope.symptomsSelected = [];
      $scope.medicinesSelected = [];
      $scope.go = function(path){
        globalFactory.go(path);
      };
     
    //  $scope.symptomList = globalFactory.getSymptomList();
      $scope.bool =false;
     
      $scope.showAdd = function(){
        $scope.bool = !$scope.bool;
      }
      $scope.saveArraySymp = function(){
      
        angular.forEach($scope.option, function(option){
          if (option.val){
            var data= {
                id: option.id,
                sympname: option.name
            }
            $scope.symptomsSelected .push(data);
          } 
        });
        console.log($scope.symptomsSelected);
      }
      $scope.saveArrayMedicine = function(){
      
        angular.forEach($scope.optionmed, function(option){
          if (option.val) {
             var data1= {
                id: option.id,
                medname: option.name
            }
            $scope.medicineSelected .push(data1);
          }
        });
        console.log($scope.medicineSelected);
      }
      $scope.saveDisease = function(){
        console.log($scope.medicinesSelected);
        console.log($scope.symptomsSelected);
        console.log($scope.diseaseName);
        globalFactory.insertDisease($scope.diseaseName,$scope.symptomsSelected,$scope.medicinesSelected);
      }
      
      $scope.addRemoveSymptom = function(hold){
    	  $scope.symptomsSelected= hold;
      }
      
      $scope.symptomsSearch = [
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
    	  $scope.medicinesSelected= hold;
      }
      
      $scope.medicinesSearch = [
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

    }
  );