angular.module('hplus.factory')

  .factory('diseaseFactory', 
    function($http, modalFactory, $window, $location, globalFactory, $rootScope){

      var registerDisease = function(diseaseObject){
        $http({
          method: 'POST',
          url: '/Disease', // Change URL here
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
            description: "Error in Registering Disease.",
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

      var updateDisease = function(disease){
        $http({
          method: "PUT",
          url: "/Doctor",
          data: doctor
        }).then(function(response){
          console.log(response);
          var modalObject = {
            type: "notify",
            title: "Successfully Updated!",
            description: "Successfully updated Dr. " + doctor.lastname + "'s profile!",
            positiveButton: "Ok",
            isVisible: true
          };
        
          modalFactory.setContents(modalObject);
          saveDoctor(response.data);
          $location.path('/admin/view/doctordetails');
        }, function(response){
          console.log(response);
          var modalObject = {
            type: "notify",
            title: "Update Failure!",
            description: "The email you have chosen already exists!",
            positiveButton: "Ok",
            isVisible: true
          };
        
          modalFactory.setContents(modalObject);
        });
      };

      var goList = function(){
        $location.path('/admin/list/doctor');
      }
      
      var confirmDeleteDisease = function(disease){
          $http({
            method: "DELETE",
            url: "/Disease",
            data: disease
          }).then(function successCallback(response){
            console.log(response);
            var modalObject = {
              type: "notify",
              title: "Archive Successful!",
              description: "Successfully archived " + disease.name + "!",
              positiveButton: "Ok",
              isVisible: true,
              data: goList
            }

            modalFactory.setContents(modalObject);
          }, function errorCallback(response){
            console.log(response);
            var modalObject = {
              type: "notify",
              title: "Archive Failed!",
              description: "Failed to archive " + disease.name + "!",
              positiveButton: "Ok",
              isVisible: true,
              data: goList
            }

            modalFactory.setContents(modalObject);
          }); 
        };
      
      var deleteDisease = function(disease){
        var modalObject = {
          type: "confirm",
          title: "Archive Confirmation",
          description: "Are you sure you want to archive " + disease.name + "?",
          negativeButton: "No",
          positiveButton: "Yes",
          isVisible: true,
          data: confirmDeleteDisease,
          object: disease
        }

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