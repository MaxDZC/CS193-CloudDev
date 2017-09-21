angular.module('hplus.factory')

  .factory('symptomFactory', 
    function($http, modalFactory, $window, $location, globalFactory, $rootScope){

      var registerSymptom = function(symptomObject, clear){
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
          clear();
        }, function errorCallback(response) {
          var errorMessage = "";
          console.log(response);
          
          var modalObject = {
            type: "notify",
            title: "Registration Failure!",
            description: "Symptom failed to save.",
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
        getSymptom: getSymptom
      }
    }
  );