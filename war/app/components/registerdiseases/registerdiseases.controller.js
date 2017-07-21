angular.module('hplus.modules.registerdiseases')

  .controller('RegisterDiseasesController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );