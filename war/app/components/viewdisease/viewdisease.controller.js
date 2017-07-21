angular.module('hplus.modules.viewdisease')

  .controller('ViewDiseaseController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );