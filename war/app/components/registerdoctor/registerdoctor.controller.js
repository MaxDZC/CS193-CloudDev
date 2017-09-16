angular.module('hplus.modules.registerdoctor')

  .controller('RegisterDoctorController',
    function($scope, globalFactory, doctorFactory, modalFactory){

      $scope.contactNoRegex = "\\d{7,}";
      $scope.passwordRegex = ".{6,}";

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
      }

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