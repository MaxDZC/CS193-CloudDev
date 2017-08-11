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
    }
  );
