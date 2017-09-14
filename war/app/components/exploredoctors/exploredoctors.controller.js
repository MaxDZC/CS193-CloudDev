angular.module('hplus.modules.exploredoctors')

  .controller('ExploreDoctorsController',
    function($scope, globalFactory, modalFactory, doctorFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.doctorList = [];

      var populate = function(){
        doctorFactory.getListOfDoctors().then(function(response){
          $scope.doctorList = response.data.doctors;
        }, function(response){
          console.log(response.statusText);
        });
      }

      populate();

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