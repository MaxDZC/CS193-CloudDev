angular.module('hplus.factory')

  .factory('symptomFactory', 
    function($http, modalFactory, $window, $location, globalFactory, $rootScope){

      var registerSymptom = function(symptomObject){
        $http({
          method: 'POST',
          url: '/Symptom', // Change URL here
          data: symptomObject
        }).then(function successCallback(response) {
        	console.log(response);
          var modalObject = {
            type: "notify",
            title: "Registration Successful!",
            description: "Symptom Saved.",
            positiveButton: "Ok",
            isVisible: true
          };
          modalFactory.setContents(modalObject);
        }, function errorCallback(response) {
          var errorMessage = response.data.errors;
          console.log(response);
          
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

      var getListOfSymptoms = function(){
        return $http({
          method: "GET",
          url: "/Symptom",
        });
      };
      
      var getListOfSymptomsID = function(symptomObject){
          return $http({
            method: "GET",
            url: "/Symptom",
            data: symptomObject
          });
        };

      var goList = function(){
        $location.path('/admin/list/disease');
      }
      var getSymptom = function(symptomObject){
        return $http({
            method: "GET",
            url: "/Symptom",
            data: symptomObject
          });
      };
      
      return {
        registerSymptom: registerSymptom,
        getListOfSymptoms: getListOfSymptoms,
        getListOfSymptomsID: getListOfSymptomsID,
        getSymptom: getSymptom
      }
    }
  );