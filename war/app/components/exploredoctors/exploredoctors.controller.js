angular.module('hplus.modules.exploredoctors')

  .controller('ExploreDoctorsController',
    function($scope, globalFactory, modalFactory, doctorFactory){

      $scope.length;

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.query = "";
      
      $scope.doctorList = [];

      var populate = function(){
        doctorFactory.getListOfDoctors().then(function(response){
          console.log(response);
          $scope.doctorList = response.data.doctors;
          $scope.length = $scope.doctorList.length;
        }, function(response){
          console.log(response.statusText);
        });
      }

      populate();

      $scope.searchFilter = function(doctor){
        if(!$scope.query 
        || (doctor.firstname.toLowerCase().indexOf($scope.query) != -1) 
        || (doctor.lastname.toLowerCase().indexOf($scope.query) != -1)
        || (doctor.specialization.toLowerCase().indexOf($scope.query) != -1)){
          return true;
        } else {
          return false;
        }
      }

      // modalFactory.setContents({
      //   type: "confirm",
      //   title: "Totally save changes",
      //   description: "Are you sure you want to save changes?",
      //   negativeButton: "No",
      //   positiveButton: "Yes",
      //   isVisible: true,
      //   data: null
      // });
    }
  );