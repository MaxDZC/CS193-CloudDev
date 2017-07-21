angular.module('hplus.modules.exploremedicalrecords')

  .controller('ExploreMedicalRecordsController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );