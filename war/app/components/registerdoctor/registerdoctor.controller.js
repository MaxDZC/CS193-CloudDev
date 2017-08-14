angular.module('hplus.modules.registerdoctor')

  .controller('RegisterDoctorController',
    function($scope, globalFactory, doctorFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };

      $scope.doctor = {};

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

      var isPasswordValid = function(){
        if($scope.doctor.password != $scope.doctor.passwordAgain){
          return false;
        } else {
          return true;
        }
      }

      $scope.registerDoctor = function(){
        if (isPasswordValid() == true){
          doctorFactory.registerDoctor($scope.doctor);
        } else {
          // Temporary for now. Should be in a modal soon.
          alert("Your passwords do not match.");
        }
      };

    }
  );