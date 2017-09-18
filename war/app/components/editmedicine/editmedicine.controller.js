angular.module('hplus.modules.editmedicine')

  .controller('EditMedicineController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.medicine = {};
      
      $scope.saveMedicine = function(){
    	  //Save Medicine I guess
      }
      
      $scope.medicineTypes = [
        { name : "Suppository",
          id : 1 },
        { name : "Tablet",
          id : 2 },
        { name : "Syrup",
          id : 3 },
        { name : "Poison",
          id : 4 }
      ];
    }
  );