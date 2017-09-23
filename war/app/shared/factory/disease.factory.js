angular.module('hplus.factory')

  .factory('diseaseFactory', 
    function($http, $rootScope, $route, modalFactory, $window, $location, globalFactory){

      var registerDisease = function(diseaseObject){
        $http({
          method: 'POST',
          url: '/Disease',
          data: diseaseObject
        }).then(function successCallback(response) {
        	console.log(response);
          var modalObject = {
            type: "notify",
            title: "Registration Successful!",
            description: "Disease Registered.",
            positiveButton: "Ok",
            isVisible: true
          };
          modalFactory.setContents(modalObject);
        }, function errorCallback(response) {
          var errorMessage = "";
          console.log(response);

          var modalObject = {
            type: "notify",
            title: "Registration Failure!",
            description: "A disease with the same name already exists!",
            positiveButton: "Ok",
            isVisible: true
          };
          modalFactory.setContents(modalObject);
        });
      }

      var getListOfDiseases = function(){
        return $http({
          method: "GET",
          url: "/Disease",
        });
      };

      var goList = function(){
        $location.path('/admin/list/disease');
        $route.reload();
      };

      var updateDisease = function(disease){
        var modalObject;

        $http({
          method: "PUT",
          url: "/Disease",
          data: disease
        }).then(function(response){
          console.log(response);
          saveDisease(response.data);
          modalObject = {
            type: "notify",
            title: "Successfully Updated!",
            description: "Successfully updated disease!",
            positiveButton: "Ok",
            isVisible: true,
            data: goList
          };
        
          modalFactory.setContents(modalObject);
        }, function(response){
          console.log(response);
          var modalObject = {
            type: "notify",
            title: "Update Failure!",
            description: "Another disease with the same name already exists!",
            positiveButton: "Ok",
            isVisible: true
          };
        
          modalFactory.setContents(modalObject);
        });
      };

      var confirmDeleteDisease = function(disease){
        var name = disease.name[0].toUpperCase() + disease.name.substr(1);

        $http({
          method: "DELETE",
          url: "/Disease",
          data: disease
        }).then(function successCallback(response){
          console.log(response);
          var modalObject = {
            type: "notify",
            title: "Archive Successful!",
            description: "Successfully archived " + name + "!",
            positiveButton: "Ok",
            isVisible: true,
            data: goList
          };

            modalFactory.setContents(modalObject);
        }, function errorCallback(response){
          console.log(response);
          var modalObject = {
            type: "notify",
            title: "Archive Failed!",
            description: "Unable to archive disease, a patient currently has this disease.",
            positiveButton: "Ok",
            isVisible: true,
            data: goList
          };

          modalFactory.setContents(modalObject);
        }); 
      };
      
      var deleteDisease = function(disease){
        var name = disease.name[0].toUpperCase() + disease.name.substr(1);
        var modalObject = {
          type: "confirm",
          title: "Archive Confirmation",
          description: "Are you sure you want to archive " + name + "?",
          negativeButton: "No",
          positiveButton: "Yes",
          isVisible: true,
          data: confirmDeleteDisease,
          object: disease
        };

        modalFactory.setContents(modalObject);
      };

      var saveDisease = function(disease){
        $window.localStorage.setItem("disease", angular.toJson(disease));
      };

      var getDisease = function(){
        return angular.fromJson($window.localStorage.getItem("disease"));
      };
  
      return {
        registerDisease: registerDisease,
        getListOfDiseases: getListOfDiseases,
        getDisease: getDisease,
        saveDisease: saveDisease,
        updateDisease: updateDisease,
        deleteDisease: deleteDisease,
      }
    }
  );