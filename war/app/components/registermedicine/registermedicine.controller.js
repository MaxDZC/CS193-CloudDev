angular.module('hplus.modules.registermedicine')

  .controller('RegisterMedicineController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );
