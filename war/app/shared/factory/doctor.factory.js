angular.module('hplus.factory')

  .factory('doctorFactory', 
    function($http){
	  
      var registerDoctor = function(doctorObject, clear){
        $http({
          method: 'POST',
          url: '/Doctor', // Change URL here
          data: doctorObject
        }).then(function successCallback(response) {
           //  {"message",true} -> Was inserted
          // {"message",false} -> An error occured
         // {"message","duplicated"} -> Email already exis
        	console.log(response);
        	clear();
            // when the response is available
          }, function errorCallback(response) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
          });
      }


      var getListOfDoctors = function(){
        return $http({
          method: "GET",
          url: "/Doctor"
        });
      }
        

      var deleteDoctor = function(deleteObject){
        $http({
          method: "POST",
          url: "/Doctor",
        }).then(function successCallback(response){
          alert("You have successfully deleted!!!");
        }, function errorCallback(response){
          var errorMessage = "";
          for(var i = 0; i < response.data.errorList.length; i++){
            errorMessage += response.data.errorList[i];
          }
          alert(errorMessage);
        });
      }
  
      return {
        registerDoctor: registerDoctor,
        getListOfDoctors: getListOfDoctors
      }
    }
  );