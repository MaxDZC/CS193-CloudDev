angular.module('hplus.factory')

  .factory('doctorFactory', 
    function($http, $route, modalFactory, $window, $location, globalFactory, $rootScope){

      var registerDoctor = function(doctorObject, clear){
        $http({
          method: 'POST',
          url: '/Doctor', // Change URL here
          data: doctorObject
        }).then(function successCallback(response) {
        	console.log(response);
          var modalObject = {
            type: "notify",
            title: "Registration Successful!",
            description: "Dr. " + doctorObject.firstname + " " + doctorObject.lastname + " is successfully registered!",
            positiveButton: "Ok",
            isVisible: true
          };
          modalFactory.setContents(modalObject);
          clear();
        }, function errorCallback(response) {
          var errorMessage = "";
          console.log(response);

          if(response.data.errors.indexOf("email") != -1){
            errorMessage = "The email "+ doctorObject.email +" is already in use!";
          }

          if(response.data.errors.indexOf("username") != -1){
            if(errorMessage != ""){
              errorMessage += "\n";
            }
            errorMessage += "The username " + doctorObject.username + " is already in use!";
          }

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

      var getListOfDoctors = function(){
        return $http({
          method: "GET",
          url: "/Doctor",
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
            description: "The email you have chosen is already in use!",
            positiveButton: "Ok",
            isVisible: true
          };
        
          modalFactory.setContents(modalObject);
        });
      };

      var goList = function(){
        $location.path('/admin/list/doctor');
        $route.reload();
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
          var doctor = response.data.doctor[0];
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
        registerDoctor: registerDoctor,
        getListOfDoctors: getListOfDoctors,
        saveDoctor: saveDoctor,
        getDoctor: getDoctor,
        updateDoctor: updateDoctor,
        deleteDoctor: deleteDoctor,
        login: login,
        saveUser: saveUser,
        getUser: getUser,
        updateView: updateView,
        logout: logout
      }
    }
  );