angular.module('hplus.modules.exploredoctors')

  .controller('ExploreDoctorsController',
    function($scope, globalFactory, modalFactory, $http){

      $scope.go = function(path){
        globalFactory.go(path);
      };

      // $scope.doctorList = [
      //   {primaryText: "Daffy Duck", secondaryText: "Optometry"},
      //   {primaryText: "Tom Cat", secondaryText: "Dentistry"},
      //   {primaryText: "Jerry Mouse", secondaryText: "Cardiology"},
      //   {primaryText: "Sylvester Cat", secondaryText: "Oncology"},
      //   {primaryText: "Nemo Fish", secondaryText: "EENT"},
      //   {primaryText: "Mickey Mouse", secondaryText: "General Surgery"},
      //   {primaryText: "Scooby Doo", secondaryText: "Anesthesiology"},
      //   {primaryText: "Courage Dog", secondaryText: "Neurology"},
      //   {primaryText: "Taron Egerton", secondaryText: "Alcohology"},
      //   {primaryText: "Tasmanian Devil", secondaryText: "Nephrology"},
      //   {primaryText: "Perry Platypus", secondaryText: "Mixology"}
      // ];

      var populate = function(){
        $http({
          method: "POST",
          url: "/Doctor",
          data: {
            action: "getDoctors"
          }
        }).then(function(response){
          console.log(response);
        }, function(response){
          console.log("I got none.");
          console.log(response);
        })
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