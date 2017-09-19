angular.module('hplus.modules.explorediseases')

  .controller('ExploreDiseasesController',
    function($scope, $location, globalFactory, doctorFactory){

      var user = doctorFactory.getUser();

      if(user == null){
        $location.path("/");
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );