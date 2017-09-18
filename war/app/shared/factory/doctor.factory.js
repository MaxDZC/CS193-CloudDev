angular.module('hplus.factory')

  .factory('doctorFactory', 
    function($http, modalFactory, $window, $location){

      var registerDoctor = function(doctorObject, clear){
        $http({
          method: 'POST',
          url: '/Doctor', // Change URL here
          data: doctorObject
        }).then(function successCallback(response) {
        	console.log(response);
          var modalObject = {
            type: "notify",
            title: "Registration Successful!",
            description: "Dr. " + doctorObject.firstname + " " + doctorObject.lastname + " is successfully registered!",
            positiveButton: "Ok",
            isVisible: true
          };
          modalFactory.setContents(modalObject);
          clear();
        }, function errorCallback(response) {
          var errorMessage = "";
          console.log(response);

          if(response.data.errors.indexOf("email") != -1){
            errorMessage = "The email "+ doctorObject.email +" already exists!";
          }

          if(response.data.errors.indexOf("username") != -1){
            if(errorMessage != ""){
              errorMessage += "\n";
            }
            errorMessage += "The username " + doctorObject.username + " already exists!";
          }

          var modalObject = {
            type: "notify",
            title: "Registration Failure!",
            description: errorMessage,
            positiveButton: "Ok",
            isVisible: true
          };
          modalFactory.setContents(modalObject);
        });
      }

      var getListOfDoctors = function(){
        return $http({
          method: "GET",
          url: "/Doctor",
        });
      };

      var updateDoctor = function(doctor){
        $http({
          method: "PUT",
          url: "/Doctor",
          data: doctor
        }).then(function(response){
          console.log(response);
          var modalObject = {
            type: "notify",
            title: "Successfully Updated!",
            description: "Successfully updated Dr. " + doctor.lastname + "'s profile!",
            positiveButton: "Ok",
            isVisible: true
          };
        
          modalFactory.setContents(modalObject);
          saveDoctor(response.data);
          $location.path('/admin/view/doctordetails');
        }, function(response){
          console.log(response);
          var modalObject = {
            type: "notify",
            title: "Update Failure!",
            description: "The email you have chosen already exists!",
            positiveButton: "Ok",
            isVisible: true
          };
        
          modalFactory.setContents(modalObject);
        });
      };
      
      var confirmDeleteDoctor = function(doctor){
        $http({
          method: "DELETE",
          url: "/Doctor",
          data: doctor
        }).then(function successCallback(response){
          console.log(response);
          $location.path('/admin/list/doctor');
        }, function errorCallback(response){
          console.log(response);
        }); 
      };

      var deleteDoctor = function(doctor){
        var modalObject = {
          type: "confirm",
          title: "Delete Confirmation",
          description: "Are you sure you want to archive Dr. " + doctor.lastname + "?",
          negativeButton: "No",
          positiveButton: "Yes",
          isVisible: true,
          data: confirmDeleteDoctor,
          object: doctor
        }

        modalFactory.setContents(modalObject);
      };

      var saveDoctor = function(doctor){
        $window.localStorage.setItem("doctor", angular.toJson(doctor));
      };

      var getDoctor = function(){
        return angular.fromJson($window.localStorage.getItem("doctor"));
      }
      
      return {
        registerDoctor: registerDoctor,
        getListOfDoctors: getListOfDoctors,
        saveDoctor: saveDoctor,
        getDoctor: getDoctor,
        updateDoctor: updateDoctor,
        deleteDoctor: deleteDoctor
      }
    }
  );