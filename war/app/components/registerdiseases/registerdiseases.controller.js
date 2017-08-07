angular.module('hplus.modules.registerdiseases')

  .controller('RegisterDiseasesController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.symptoms = [
        {
          name: "Examples",
          id: 1
        },
        {
          name: "of",
          id: 2
        },
        {
          name: "Symptoms",
          id: 3
        },
        {
          name: "wooh",
          id: 4
        }
      ];

    }
  );