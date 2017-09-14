angular.module('hplus.modules.registerdoctor')

  .controller('RegisterDoctorController',
    function($scope, globalFactory, doctorFactory){

	  $scope.regex = "\\d{7,}";
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
          doctorFactory.registerDoctor($scope.doctor, $scope.initComponents);
       //   $scope.initComponents();
        } else {
          // Temporary for now. Should be in a modal soon.
        	SweetAlert.swal("Your passwords do not match.");
        }
      };
      
      $scope.initComponents = function(){
    	  $scope.doctor.fname = "";
    	  $scope.doctor.lname = "";
    	  $scope.doctor.specialization = "";
    	  $scope.doctor.address = "";
    	  $scope.doctor.number = "";
    	  $scope.doctor.birthday = "";
    	  $scope.doctor.username = "";
    	  $scope.doctor.password = "";
    	  $scope.doctor.passwordAgain = "";
    	  $scope.doctor.email = "";
      }

    }
  );