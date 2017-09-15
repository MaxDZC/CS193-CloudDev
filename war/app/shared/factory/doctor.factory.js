angular.module('hplus.factory')

  .factory('doctorFactory', 
    function($http){

      var registerDoctor = function(doctorObject){

        doctorObject.push(action, "registerDoctor");

        $http({
          method: "POST",
          url: "/Doctor", // Change URL here
          data: doctorObject
        }).then(function successCallback(response) {
           //  {"message",true} -> Was inserted
          // {"message",false} -> An error occured
         // {"message","duplicated"} -> Email already exis
        	console.log(response);
            // when the response is available
          }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
          });
      }

      var getListOfDoctors = function(){
        return $http({
          method: "GET",
          url: "/Doctor"
        });
      }

      var updateDoctor = function(doctorObject){

        doctorObject.push(action, "updateDoctor");

        return $http({
          method: "POST",
          url: "/Doctor",
          data: doctorObject
        });
      }

      var deleteDoctor = function(doctorObject){

        doctorObject.push(action, "deleteDoctor");

        return $http({
          method: "POST",
          url: "/Doctor",
          data: doctorObject
        });
      }
        

      
      return {
        registerDoctor: registerDoctor,
        getListOfDoctors: getListOfDoctors,
        updateDoctor: updateDoctor,
        deleteDoctor: deleteDoctor
      }
    }
  );