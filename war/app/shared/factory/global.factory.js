angular.module('hplus.factory')

  .factory('globalFactory', 
    function($location,$http){
      var loginedUser = null;
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
              go("/admin/list/record");
            // when the response is available
          }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
          });
      }
   
      return{
        go: go,
        login:login
      };
    }
  );