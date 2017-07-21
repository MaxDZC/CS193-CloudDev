angular.module('hplus.modules.editdisease')

  .controller('EditDiseaseController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );
  