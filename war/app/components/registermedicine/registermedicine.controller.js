angular.module('hplus.modules.registermedicine')

  .controller('RegisterMedicineController',
    function($scope, globalFactory, medicineFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.medicine = {};
      
      $scope.registerMedicine = function(){
        medicineFactory.registerMedicine($scope.medicine);
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
