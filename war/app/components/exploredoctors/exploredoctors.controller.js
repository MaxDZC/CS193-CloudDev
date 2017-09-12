angular.module('hplus.modules.exploredoctors')

  .controller('ExploreDoctorsController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };

      $scope.doctorList = [
        {primaryText: "Daffy Duck", secondaryText: "Optometry"},
        {primaryText: "Tom Cat", secondaryText: "Dentistry"},
        {primaryText: "Jerry Mouse", secondaryText: "Cardiology"},
        {primaryText: "Sylvester Cat", secondaryText: "Oncology"},
        {primaryText: "Nemo Fish", secondaryText: "EENT"},
        {primaryText: "Mickey Mouse", secondaryText: "General Surgery"},
        {primaryText: "Scooby Doo", secondaryText: "Anesthesiology"},
        {primaryText: "Courage Dog", secondaryText: "Neurology"},
        {primaryText: "Taron Egerton", secondaryText: "Alcohology"},
        {primaryText: "Tasmanian Devil", secondaryText: "Nephrology"},
        {primaryText: "Perry Platypus", secondaryText: "Mixology"}
      ];
    }
  );