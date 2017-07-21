angular.module('hplus.modules.explorediseases')

  .controller('ExploreDiseasesController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );