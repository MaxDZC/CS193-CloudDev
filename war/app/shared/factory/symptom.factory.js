angular.module('hplus.factory')

  .factory('symptomFactory', 
    function($http, modalFactory, $window, $location, globalFactory, $rootScope){

      var registerSymptom = function(symptomObject){
        var modalObject;

        $http({
          method: 'POST',
          url: '/Symptom', // Change URL here
          data: symptomObject
        }).then(function successCallback(response) {
        	console.log(response);
          modalObject = {
            type: "notify",
            title: "Registration Successful!",
            description: "Symptom Saved.",
            positiveButton: "Ok",
            isVisible: true
          };

          modalFactory.setContents(modalObject);
          $rootScope.$broadcast("repopulate");
        }, function errorCallback(response) {
          console.log(response);
          modalObject = {
            type: "notify",
            title: "Registration Failure!",
            description: "Symptom with the same name already exists!",
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