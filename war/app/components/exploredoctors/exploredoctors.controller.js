angular.module('hplus.modules.exploredoctors')

  .controller('ExploreDoctorsController',
    function($scope, $location, globalFactory, modalFactory, doctorFactory){

      var user = doctorFactory.getUser();

      if(user != null){
        if(!user.admin){
          $location.path("/admin/list/record");
        }
      } else {
        $location.path("/");
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.query = "";
      
      $scope.doctorList = [];

      var populate = function(){
        doctorFactory.getListOfDoctors().then(function(response){
          console.log(response);
          $scope.doctorList = response.data.doctors;
          $scope.medicalRecords = response.data.medicalRecords;
          var x, y;

          for(x = 0; x < $scope.doctorList.length; x++){
            for(y = 0; y < $scope.medicalRecords.length; y++){
              if($scope.doctorList[x].id == $scope.medicalRecords[y].doctorId){
                if($scope.doctorList[x].medicalRecords == null){
                  $scope.doctorList[x].medicalRecords = [];
                }
                $scope.doctorList[x].medicalRecords.push($scope.medicalRecords[y]);
              } 
            }
          }
        }, function(response){
          console.log(response.statusText);
        });
      };

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
      };
    }
  );