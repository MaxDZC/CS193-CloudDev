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
	  
	  $scope.searchFilter = "";
	  
	  $scope.patients =[ 
	    {
		  "firstName" : "John",
		  "lastName" : "Doe",
		  "createdAt" : "1970-01-01T09:05:05.035Z",
		  "diseases" : ["Dying"]
	    },
	    {
		  "firstName" : "Joe",
		  "lastName" : "Doe",
		  "createdAt" : "1970-01-01T09:05:05.035Z",
		  "diseases" : ["Genital Retraction Syndrome"]
	    },
	    {
		  "firstName" : "Jane",
		  "lastName" : "Doe",
		  "createdAt" : "1970-01-01T09:05:05.035Z",
		  "diseases" : ["Trichophagia","Tuberculosis"]
	    }
	  ];
	}
  );