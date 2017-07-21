angular.module('hplus.modules.viewmedicine')

  .controller('ViewMedicineController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );