angular.module('hplus.factory')

  .factory('globalFactory', function($location,$http,$rootScope){
      var user;
      var insertDisease = function(name,symptoms,medicine){
        var dataDisease = {
          diseasename:name,
          symptomsid:symptoms,
          medicineid:medicine
        }
        console.log("here" + dataDisease.medicineid[0].name);
         $http({
          method:"POST",
          url:"/Disease",
          data:dataDisease
         }).then(function successCallback(response) {
           //  {"message",true} -> Was inserted
          // {"message",false} -> An error occured
         // {"message","duplicated"} -> Email already exis
        
              console.log(response);
              go("/admin/list/disease");
            // when the response is available
          }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
          });
      }
      
      var go = function(path){
        $location.path(path);
      };

      var login = function(user,pass){
          var actionl = "login";
          var data = {
                        username:user,
                        password:pass,
                        action: actionl
                     };
          $http({
              method:"GET",
              url:"/Doctor",
              params:data
          })
          .then(function successCallback(response) {
           //  {"message",true} -> Was inserted
          // {"message",false} -> An error occured
         // {"message","duplicated"} -> Email already exis
              console.log(response);
              var users = {
                        username:response.data.doctors.username,
                        firstname:response.data.doctors.firstName,
                        lastname:response.data.doctors.lastName,
                        birthday:response.data.doctors.birthday,
                        contactNo:response.data.doctors.contactNo,
                        specialization:response.data.doctors.specialization,
                        address:response.data.doctors.address
                     };
              $rootScope.$broadcast('loginUserContents', users);
              console.log("user:" + user.username);
              go("/admin/list/record");
            // when the response is available
          }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
          });
      }
   
      return{
        go: go,
        login:login,
        insertDisease:insertDisease
      };
    }
  );