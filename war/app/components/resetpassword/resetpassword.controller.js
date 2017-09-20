angular.module('hplus.modules.resetpassword')

  .controller('ResetPasswordController',
    function($scope, $location, globalFactory, modalFactory, doctorFactory){

      $scope.passwordRegex = ".{6,}";
      $scope.meter = "meter-bar";
      $scope.passwordStatus = "Enter a password";

      var errorMessage = "";

      var user = doctorFactory.getUser();
      console.log(user);

      if(user == null) {
        $location.path("/");
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };

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
      })

      var validity = function(){
        console.log($scope.passwordStrength.password + " ");
        console.log(user.password);
        if($scope.passwordStrength.password == $scope.password.confirmPass && $scope.password.oldPass == user.password){
          state = true;
        } else {
          state = false;
          errorMessage += "Passwords don't match!";
        }

        return state;
      };

      var confirmPasswordReset = function(){
        user.password = $scope.password.newPass;
        doctorFactory.updateDoctor(user);
      };

      $scope.resetPassword = function(){
        var modalObject = {};
        console.log("resetPassword");

        if(validity()){
          modalObject = {
            type: "confirm",
            title: "Confirm Password Reset",
            description: "Are you sure you want to change your password?",
            negativeButton: "No",
            positiveButton: "Yes",
            isVisible: true,
            data: confirmPasswordReset
          };
        
          modalFactory.setContents(modalObject);
        } else {
          modalObject = {
            type: "notify",
            title: "Unable to change password!",
            description: errorMessage,
            positiveButton: "Ok",
            isVisible: true
          };
          
          modalFactory.setContents(modalObject);
        }
      };
    }
  );