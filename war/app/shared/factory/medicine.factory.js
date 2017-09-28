angular.module('hplus.factory')

  .factory('medicineFactory', 
    function($http, $route, modalFactory, $window, $location){

      var registerMedicine = function(medicineObject){
        $http({
          method: 'POST',
          url: '/Medicine',
          data: medicineObject
        }).then(function successCallback(response) {
        	console.log(response);
            var modalObject = {
              type: "notify",
              title: "Registration Successful!",
              description: medicineObject.name + " " + "is successfully registered!",
              positiveButton: "Ok",
              isVisible: true
            };

            modalFactory.setContents(modalObject);
          }, function errorCallback(response) {
              console.log(response);
              var modalObject = {
                type: "notify",
                title: "Registration Failure!",
                description: "A medicine with the same name is already registered!",
                positiveButton: "Ok",
                isVisible: true
              };

              modalFactory.setContents(modalObject);
          });
      }
      
      var getListOfMedicines = function(){
        return $http({
          method: "GET",
          url: "/Medicine",
        });
      };
      
      var updateMedicine = function(medicine){
          $http({
            method: "PUT",
            url: "/Medicine",
            data: medicine
          }).then(function(response){
            console.log(response);
            var modalObject = {
              type: "notify",
              title: "Successfully Updated!",
              description: "Successfully updated " + medicine.name + "!",
              positiveButton: "Ok",
              isVisible: true
            };
          
            modalFactory.setContents(modalObject);
            saveMedicine(response.data);
            $location.path('/admin/view/medicine');
          }, function(response){
            console.log(response);
            var modalObject = {
              type: "notify",
              title: "Update Failure!",
              description: "This medicine name already exists",
              positiveButton: "Ok",
              isVisible: true
            };
            
            modalFactory.setContents(modalObject);
          });
        };
            
        var goList = function(){
          $location.path('/admin/list/medicine');
          $route.reload();
        }
        
        var confirmDeleteMedicine = function(medicine){
            $http({
              method: "DELETE",
              url: "/Medicine",
              data: medicine
            }).then(function successCallback(response){
              console.log(response);
              var modalObject = {
                type: "notify",
                title: "Archive Successful!",
                description: "Successfully archived " + medicine.name + "!",
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
                  description: medicine.name + " is currently in use!",
                  positiveButton: "Ok",
                  isVisible: true
                };

                modalFactory.setContents(modalObject);
              }); 
            };
            
	    var deleteMedicine = function(medicine){
          var modalObject = {
	          type: "confirm",
	          title: "Archive Confirmation",
	          description: "Are you sure you want to archive " + medicine.name + "?",
	          negativeButton: "No",
	          positiveButton: "Yes",
	          isVisible: true,
            data: confirmDeleteMedicine,
            object: medicine
        };
	
        modalFactory.setContents(modalObject);
      };
	      
      var saveMedicine = function(medicine){
          $window.localStorage.setItem("medicine", angular.toJson(medicine));
      };
      
	    var getMedicine = function(){
	      return angular.fromJson($window.localStorage.getItem("medicine"));
	    };  
      
      return {
        registerMedicine: registerMedicine,
        getListOfMedicines: getListOfMedicines,
        saveMedicine: saveMedicine,
        getMedicine: getMedicine,
        updateMedicine: updateMedicine,
        deleteMedicine: deleteMedicine
      }
    }
  );