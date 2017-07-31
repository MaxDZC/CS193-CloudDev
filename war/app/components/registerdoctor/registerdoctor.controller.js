angular.module('hplus.modules.registerdoctor')

  .controller('RegisterDoctorController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };

      $scope.selectedSpecialization = "";

      $scope.specialization = [
        {
          name: "Cardiology",
          id: 1
        },
        {
          name: "Dentistry",
          id: 2
        },
        {
          name: "Nephrology",
          id: 3
        }
      ];

    }
  );