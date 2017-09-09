angular.module('hplus.modules.editmedicine')

  .controller('EditMedicineController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );