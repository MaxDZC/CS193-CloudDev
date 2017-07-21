angular.module('hplus.modules.exploredoctors')

  .controller('ExploreDoctorsController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );