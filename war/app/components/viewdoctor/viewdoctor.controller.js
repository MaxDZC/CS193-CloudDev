angular.module('hplus.modules.viewdoctor')

  .controller('ViewDoctorController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );