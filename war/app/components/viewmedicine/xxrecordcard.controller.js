angular.module('hplus.modules.viewmedicine')

  .controller('RecordCardController',
    function($scope, $location, globalFactory){
      
      $scope.go = function(path, medicalRecord){
        console.log("atay");
        globalFactory.go(path);
      };

  });