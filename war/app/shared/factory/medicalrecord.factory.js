angular.module('hplus.factory')

  .factory('medicalRecordFactory', 
    function($http){

      var createMedicalRecord = function(medicalRecordObject, clear){
        return $http({
          method: 'POST',
          url: '/MedicalRecord', // Change URL here
          data: medicalRecordObject
        }).then(function successCallback(response) {
            // this callback will be called asynchronously
            // when the response is available
        	console.log(response);
        	clear();
          }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        	  var errorMessage = "";
        	  
        	  for(var i=0; i < response.data.errorList.length; i++){
        		  errorMessage += response.data.errorList[i];
        	  }
        	  
        	  alert(errorMessage);
          });
      }
      
      var getListOfMedicalRecords = function(){
          return $http({
            method: 'GET',
            url: '/MedicalRecord' // Change URL here
          });
        }
      
      return {
    	  createMedicalRecord: createMedicalRecord,
    	  getListOfMedicalRecords: getListOfMedicalRecords
      }
    }
  );