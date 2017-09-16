angular.module('hplus.factory')

  .factory('doctorFactory', 
    function($http, modalFactory){

      var savedDoctor = {};
	  
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
          url: "/Doctor"
        });
      }
        

      var deleteDoctor = function(deleteObject){
        $http({
          method: "POST",
          url: "/Doctor",
        }).then(function successCallback(response){
          alert("You have successfully deleted!!!");
        }, function errorCallback(response){
          var errorMessage = "";
          for(var i = 0; i < response.data.errorList.length; i++){
            errorMessage += response.data.errorList[i];
          }
          alert(errorMessage);
        });
      }

      var saveDoctor = function(doctor){
        savedDoctor = doctor;
      };

      var getDoctor = function(){
        return savedDoctor;
      }
      
      return {
        registerDoctor: registerDoctor,
        getListOfDoctors: getListOfDoctors,
        saveDoctor: saveDoctor,
        getDoctor: getDoctor
      }
    }
  );