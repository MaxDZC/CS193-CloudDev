angular.module('hplus.modules.explorediseases')

  .controller('CardController',
    function($scope, globalFactory, diseaseFactory){
      
      $scope.go = function(path, disease){
        diseaseFactory.saveDisease(disease);
        globalFactory.go(path);
      };

      $scope.delete = function(disease){
        diseaseFactory.deleteDisease(disease);
      };
    }
  );