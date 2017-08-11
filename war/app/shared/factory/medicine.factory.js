angular.module('hplus.factory')

  .factory('medicineFactory', 
    function($http){

      var registerMedicine = function(medicineObject){
        $http({
          method: 'POST',
          url: '/Medicine', // Change URL here
          data: medicineObject
        }).then(function successCallback(response) {
            // this callback will be called asynchronously
            // when the response is available
          }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
          });
      }
      
      return {
        registerMedicine: registerMedicine
      }
    }
  );