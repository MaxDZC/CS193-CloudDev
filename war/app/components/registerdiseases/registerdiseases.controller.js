angular.module('hplus.modules.registerdiseases')

  .controller('RegisterDiseasesController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.checkSelected= function(){
    	  if($scope.symptomsSelected.length && $scope.medicinesSelected.length){
    		  //alert.alert
    		  alert("There is Selected!");
    	  }else{
    		  alert("Select at least one Symptom or Medicine");
    	  }
      };
      
      $scope.symptomsSelected = [
      ];
      
      $scope.addSymptom = function(hold){
    	  $scope.symptomsSelected.push(hold);
    	  $scope.symptomsSearch.splice($scope.symptomsSearch.indexOf(hold),1);
      };
      
      $scope.removeSymptom = function(hold){
    	  $scope.symptomsSearch.push(hold);
    	  $scope.symptomsSelected.splice($scope.symptomsSelected.indexOf(hold),1);
      };
      
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
      
      $scope.medicinesSelected = [
                                 ];
                                 
      $scope.addMedicine = function(hold){
        $scope.medicinesSelected.push(hold);
        $scope.medicinesSearch.splice($scope.medicinesSearch.indexOf(hold),1);
      };
                                 
      $scope.removeMedicine = function(hold){
        $scope.medicinesSearch.push(hold);
        $scope.medicinesSelected.splice($scope.medicinesSelected.indexOf(hold),1);
      };
      
      $scope.medicinesSearch = [
                         {
                           name: "Metformin",
                           id: 1
                         },
                         {
                           name: "Meth",
                           id: 2
                         },
                         {
                           name: "Methamphetamine",
                           id: 3
                         },
                         {
                           name: "Methazolamide",
                           id: 4
                         },
                         {
                           name: "Methazolamide",
                           id: 5
                         },
                         {
                           name: "Meth",
                           id: 6
                         },
                         {
                           name: "Methenamine",
                           id: 7
                         },
                         {
                           name: "Methimazole",
                           id: 8
                         },
                         {
                           name: "Meth",
                           id: 9
                         }
                       ];

    }
  );