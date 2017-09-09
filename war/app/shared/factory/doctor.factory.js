angular.module('hplus.factory')

  .factory('doctorFactory', 
    function($http){

      var registerDoctor = function(doctorObject){
        $http({
          method: 'POST',
          url: '/Doctor', // Change URL here
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
      
      return {
        registerDoctor: registerDoctor
      }
    }
  );