angular.module('hplus.factory')

  .factory('patientFactory',
    function($http, modalFactory, $window, $location){

      var registerPatient = function(patient){
        $http({
          method: 'POST',
          url: '/Patient',
          data: patient
        }).then(function successCallback(response) {
          console.log(response);
          
          var modalObject = {
            type: "notify",
            title: "Registration Successful!",
            description: patient.firstname + " " + patient.lastname + " is successfully registered!",
            positiveButton: "Ok",
            isVisible: true
          };

          modalFactory.setContents(modalObject);
        }, function errorCallback(response) {
          console.log(response);

          var modalObject = {
            type: "notify",
            title: "Registration Failure!",
            description: "This patient already exists!",
            positiveButton: "Ok",
            isVisible: true
          };

          modalFactory.setContents(modalObject);
        });
      }

      var getListOfPatients = function(){
          return $http({
            method: "GET",
            url: "/Patient",
          });
        };

        var updatePatient = function(patient){
            $http({
              method: "PUT",
              url: "/Patient",
              data: patient
            }).then(function(response){
              console.log(response);
              var modalObject = {
                type: "notify",
                title: "Successfully Updated!",
                description: "Successfully updated " + patient.lastname + "'s profile!",
                positiveButton: "Ok",
                isVisible: true
              };

              modalFactory.setContents(modalObject);
              savePatient(response.data);
              $location.path('/admin/view/patientdetails');
            }, function(response){
                console.log(response);
                var modalObject = {
                  type: "notify",
                  title: "Update Failure!",
                  description: "This patient already exist",
                  positiveButton: "Ok",
                  isVisible: true
                };

                modalFactory.setContents(modalObject);
              });
            };

            var goList = function(){
                $location.path('/admin/list/patient');
              }

            var confirmDeletePatient = function(patient){
                $http({
                  method: "DELETE",
                  url: "/Patient",
                  data: patient
                }).then(function successCallback(response){
                  console.log(response);
                  var modalObject = {
                    type: "notify",
                    title: "Archive Successful!",
                    description: "Successfully archived " + patient.lastname + "!",
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
                    description: "Failed to archive " + patient.lastname + "!",
                    positiveButton: "Ok",
                    isVisible: true,
                    data: goList
                  }

                  modalFactory.setContents(modalObject);
                });
              };

              var deletePatient = function(patient){
                  var modalObject = {
                    type: "confirm",
                    title: "Archive Confirmation",
                    description: "Are you sure you want to archive " + patient.lastname + "?",
                    negativeButton: "No",
                    positiveButton: "Yes",
                    isVisible: true,
                    data: confirmDeletePatient,
                    object: patient
                  }

                  modalFactory.setContents(modalObject);
                };

                var savePatient = function(patient){
                  $window.localStorage.setItem("patient", angular.toJson(patient));
                };

                var getPatient = function(){
                  return angular.fromJson($window.localStorage.getItem("patient"));
                };


      return {
        registerPatient: registerPatient,
        getListOfPatients: getListOfPatients,
        savePatient: savePatient,
        getPatient: getPatient,
        updatePatient: updatePatient,
        deletePatient: deletePatient
      }
    }
  );
