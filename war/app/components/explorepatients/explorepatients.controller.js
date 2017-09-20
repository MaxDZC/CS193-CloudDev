angular.module('hplus.modules.explorepatients')

  .controller('ExplorePatientsController',
    function($scope, globalFactory, modalFactory, patientFactory){

      $scope.length;

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.patientList = [
     
    {
        name: "Doe, Jane",
  		  date: "Feb. 20, 2016",
  		  disease: "Wisdom Tooth Eruption",
        id: 1
      },
      {
        name: "Phour, Mahn",
  		  date: "June 19, 2015",
  		  disease: "Gingivitis, Periodontitis, Dental Calculus",
        id: 2
      }
      
      ];

      var populate = function(){
        patientFactory.getListOfPatients().then(function(response){
          console.log(response);
          $scope.patientList = response.data.patients;
          $scope.length = $scope.patientList.length;
        }, function(response){
          console.log(response.statusText);
        });
      }

      populate();

      $scope.searchFilter = function(patient){
        if(!$scope.query 
        || (patient.firstname.toLowerCase().indexOf($scope.query) != -1) 
        || (patient.lastname.toLowerCase().indexOf($scope.query) != -1)
        || (patient.specialization.toLowerCase().indexOf($scope.query) != -1)){
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