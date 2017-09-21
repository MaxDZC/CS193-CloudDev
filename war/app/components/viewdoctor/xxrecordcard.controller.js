angular.module('hplus.modules.viewdoctor')

  .controller('RecordCardController',
    function($scope, $location, globalFactory){
      
      $scope.go = function(path, medicalRecord){
        globalFactory.go(path);
      };

  });