angular.module('hplus.modules.viewmedicine')

  .controller('RecordCardController',
    function($scope, $location, globalFactory){
      $scope.go = function(path, medicalRecord){
        globalFactory.go(path);
      };

  });