angular.module('hplus.modules.explorepatients')

  .controller('ExplorePatientsController',
    function($scope, $location, globalFactory, doctorFactory, modalFactory, patientFactory){

      $scope.length;
      $scope.selectedPatient = null;
      $scope.query = "";
      
      var user = doctorFactory.getUser();

      if(user == null){
        $location.path("/");
      }

      var populate = function(){
        patientFactory.getListOfPatients().then(function(response){
          console.log(response);
          $scope.patientList = response.data.patients;
        }, function(response){
          console.log(response);
        });
      };

      populate();
      
      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.setSelected = function(pat){
    	  $scope.selectedPatient = pat;
      };

      $scope.searchFilter = function(patient){
        if(!$scope.query 
        || (patient.firstname.toLowerCase().indexOf($scope.query) != -1) 
        || (patient.lastname.toLowerCase().indexOf($scope.query) != -1)){
          return true;
        } else {
          return false;
        }
      }
    }
  );