angular.module('hplus.factory')

  .factory('patientFactory', 
    function($http){

      var registerPatient = function(patientObject){
        $http({
          method: 'POST',
          url: '/registerPatient', // Change URL here
          data: patientObject
        }).then(function successCallback(response) {
            // this callback will be called asynchronously
            // when the response is available
          }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
          });
      }
      
      return {
        registerPatient: registerPatient
      }
    }
  );