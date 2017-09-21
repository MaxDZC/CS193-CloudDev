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

      var updateDoctor = function(doctor){
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
      
      var confirmDeleteDoctor = function(doctor){
        $http({
          method: "DELETE",
          url: "/Doctor",
          data: doctor
        }).then(function successCallback(response){
          console.log(response);
          var modalObject = {
            type: "notify",
            title: "Archive Successful!",
            description: "Successfully archived Dr. " + doctor.lastname + "!",
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
            description: "Failed to archive Dr. " + doctor.lastname + "!",
            positiveButton: "Ok",
            isVisible: true,
            data: goList
          }

          modalFactory.setContents(modalObject);
        }); 
      };

      var deleteDoctor = function(doctor){
        var modalObject = {
          type: "confirm",
          title: "Archive Confirmation",
          description: "Are you sure you want to archive Dr. " + doctor.lastname + "?",
          negativeButton: "No",
          positiveButton: "Yes",
          isVisible: true,
          data: confirmDeleteDoctor,
          object: doctor
        }

        modalFactory.setContents(modalObject);
      };

      var saveDoctor = function(doctor){
        $window.localStorage.setItem("doctor", angular.toJson(doctor));
      };

      var getDoctor = function(){
        return angular.fromJson($window.localStorage.getItem("doctor"));
      };

      var saveUser = function(user){
        $window.localStorage.setItem("user", angular.toJson(user));
      };

      var getUser = function(){
        return angular.fromJson($window.localStorage.getItem("user"));
      };

      var logout = function(){
        $window.localStorage.removeItem("user");
        $rootScope.$broadcast("changeNavbarOut");
      };

      var login = function(user, pass){
        var data = {
          username:user,
          password:pass
        };
        
        $http({
            method:"GET",
            url:"/Doctor",
            params: data
        }).then(function successCallback(response) {
          console.log(response);
          var doctor = JSON.parse(response.data.doctor);
          var modalObject = {
            type: "notify",
            title: "Login Successful!",
            description: "Welcome Dr. " + doctor.lastname + "!",
            positiveButton: "Ok",
            isVisible: true
          }

          modalFactory.setContents(modalObject);

          saveUser(doctor);
          $rootScope.$broadcast("userLoggedIn", doctor);
          $rootScope.$broadcast("changeNavbar", doctor);
          globalFactory.go("/admin/list/record");
        }, function errorCallback(response) {
          console.log(response);
          var modalObject = {
            type: "notify",
            title: "Authentication Failed!",
            description: "Wrong username/email and/or password!",
            positiveButton: "OK",
            isVisible: true
          }

          modalFactory.setContents(modalObject);
        });
      };

      var updateView = function(){
        $rootScope.$broadcast("updateProfile");
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