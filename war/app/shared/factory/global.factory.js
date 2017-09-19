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
   
      return{
        go: go,
        insertDisease:insertDisease
      };
    }
  );