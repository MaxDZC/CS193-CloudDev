angular.module('hplus.modules.exploremedicalrecords')

  .controller('ExploreMedicalRecordsController',
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