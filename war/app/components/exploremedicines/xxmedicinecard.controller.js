angular.module('hplus.modules.exploremedicines')

  .controller('MedicineCardController',
    function($scope, $location, globalFactory, doctorFactory, medicineFactory, modalFactory){
      
      var user = doctorFactory.getUser();
      
      $scope.isAdmin = function(){
        return user.admin;
      };

      $scope.go = function(path, medicine) {
        medicineFactory.saveMedicine(medicine);
        globalFactory.go(path);
      };

      $scope.delete = function(medicine) {
        medicineFactory.deleteMedicine(medicine);
      };

    }
  );