angular.module('hplus.modules.registermedicine')

  .controller('RegisterMedicineController',
    function($scope, $location, globalFactory, medicineFactory, doctorFactory){

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
      
      $scope.medicine = {};
      
      $scope.registerMedicine = function(){
    	  medicineFactory.registerMedicine($scope.medicine);
      }
    }
  );
