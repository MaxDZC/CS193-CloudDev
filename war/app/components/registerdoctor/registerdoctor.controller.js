angular.module('hplus.modules.registerdoctor')

  .controller('RegisterDoctorController',
    function($scope, $location, globalFactory, doctorFactory, modalFactory){

      var user = doctorFactory.getUser();
      console.log(user);

      if(user != null) {
        if(!user.admin){
          $location.path("/admin/list/record");
        }
      } else {
        $location.path("/");
      }

      $scope.contactNoRegex = "\\d{7,}";
      $scope.passwordRegex = ".{6,}";
      $scope.meter = "meter-bar";
      $scope.passwordStatus = "Enter a password";

      var errorMessage = "";

      $scope.go = function(path){
        globalFactory.go(path);
      };

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

      $scope.$watch(
        // This function returns the value being watched. It is called for each turn of the $digest loop
        function() { return $scope.passwordStrength; },
        // This is the change listener, called when the value returned from the above function changes
        function(newValue, oldValue) {
          if (newValue != undefined && newValue.password != "") {
            switch(newValue.score){
              case 0:
                $scope.meter = "meter-bar meter-bar-verybad";
                $scope.passwordStatus = "Very Weak";
                break;
              case 1:
                $scope.meter = "meter-bar meter-bar-bad";
                $scope.passwordStatus = "Weak";
                break;
              case 2:
                $scope.meter = "meter-bar meter-bar-average";
                $scope.passwordStatus = "Average";
                break;
              case 3:
                $scope.meter = "meter-bar meter-bar-good";
                $scope.passwordStatus = "Strong";
                break;
              case 4:
                $scope.meter = "meter-bar meter-bar-verygood";
                $scope.passwordStatus = "Very Strong";
            }
          } else {
            $scope.meter = "meter-bar";
            $scope.passwordStatus = "Enter a password";
          }
      });

      $scope.checkStatus = function(status){
        var retType;

        if(status) {
          $scope.button = "Register Doctor";
          retType = "edit-button";
        } else {
          $scope.button = "Please fill out all of the fields correctly";
          retType = "delete-button";
        }

        return retType;
      }

      var validity = function(){
        var state;
        var yearDiff;

        if(Date.now() - $scope.doctor.birthday.getTime < 0){
          yearDiff = Date.now() + $scope.doctor.birthday.getTime();
        } else {
          yearDiff = Date.now() - $scope.doctor.birthday.getTime();
        }

        yearDiff = new Date(yearDiff);
        yearDiff = parseInt(Math.abs(yearDiff.getUTCFullYear() - 1970));
        errorMessage = "";

        if($scope.doctor.password == $scope.doctor.passwordAgain){
          state = true;
        } else {
          state = false;
          errorMessage += "Passwords don't match!";
        }

        if(yearDiff <= 24 || yearDiff >= 66) {
          state = false;
          if(errorMessage != ""){
            errorMessage += "\n";
          }
          errorMessage += "Invalid age! You can't be " + yearDiff + " years old!";
        }

        return state;
      }

      var confirmRegisterDoctor = function(doctor, initComponents){
        doctorFactory.registerDoctor(doctor, initComponents);
      };

      $scope.registerDoctor = function(){
        var modalObject = {};

        if(validity()){
          modalObject = {
            type: "confirm",
            title: "Confirm Registration",
            description: "Are you sure you want to register " + $scope.doctor.firstname + "?",
            negativeButton: "No",
            positiveButton: "Yes",
            isVisible: true,
            data: confirmRegisterDoctor,
            object: $scope.doctor,
            clean: $scope.initComponents
          };
        
          modalFactory.setContents(modalObject);
        } else {
          modalObject = {
            type: "notify",
            title: "Unable to register doctor!",
            description: errorMessage,
            positiveButton: "Ok",
            isVisible: true
          };
          
          modalFactory.setContents(modalObject);
        }
      };
      
      $scope.initComponents = function(){
    	  $scope.doctor.firstname = "";
    	  $scope.doctor.lastname = "";
    	  $scope.doctor.specialization = "";
    	  $scope.doctor.address = "";
    	  $scope.doctor.contactNo = "";
    	  $scope.doctor.birthday = "";
    	  $scope.doctor.username = "";
    	  $scope.doctor.password = "";
    	  $scope.doctor.passwordAgain = "";
    	  $scope.doctor.email = "";
      };

    }
  );