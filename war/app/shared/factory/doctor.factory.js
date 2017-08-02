angular.module('hplus.factory')

  .factory('doctorFactory', 
    function($http){

      var registerDoctor = function(doctorObject){
        $http({
          method: 'POST',
          url: '/registerDoctor', // Change URL here
          data: doctorObject
        }).then(function successCallback(response) {
            // this callback will be called asynchronously
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