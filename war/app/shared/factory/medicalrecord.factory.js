angular.module('hplus.factory')

  .factory('medicalRecordFactory', 
    function($http, $window){

      var createMedicalRecord = function(medicalRecordObject, clear){
        return $http({
          method: 'POST',
          url: '/MedicalRecord', // Change URL here
          data: medicalRecordObject
        }).then(function successCallback(response) {
        	console.log(response);
        	clear();
          }, function errorCallback(response) {
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
      };
      
      var saveMedicalRecord = function(medicine){
        $window.localStorage.setItem("medicalRecord", angular.toJson(medicine));
      };
    
      var getMedicalRecord = function(){
        return angular.fromJson($window.localStorage.getItem("medicalRecord"));
      };  

      return {
    	  createMedicalRecord: createMedicalRecord,
        getListOfMedicalRecords: getListOfMedicalRecords,
        saveMedicalRecord: saveMedicalRecord,
        getMedicalRecord: getMedicalRecord
      }
    }
  );