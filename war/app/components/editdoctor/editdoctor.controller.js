angular.module('hplus.modules.editdoctor')

  .controller('EditDoctorController',
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
    }
  );