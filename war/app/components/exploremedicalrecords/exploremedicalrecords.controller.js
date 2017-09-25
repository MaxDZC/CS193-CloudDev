angular.module('hplus.modules.exploremedicalrecords')

  .controller('ExploreMedicalRecordsController',
	function($scope, $location, globalFactory, doctorFactory, patientFactory, medicalRecordFactory, diseaseFactory){

		$scope.user = doctorFactory.getUser();

		if($scope.user == null){
			$location.path("/");
		}
		
	  $scope.go = function(path){
			globalFactory.go(path);
	  };
	  
	  $scope.searchFilter = "";
	  
	  $scope.medRecs =[];
	  
	  $scope.medicalRecords = [];
	  
	  var populate = function(){
	    console.log("medFactoryStart");
	    patientFactory.getListOfPatients().then(function(response){
	      $scope.patients = response.data.patients;
	      console.log(response.data.patients);
	    },function(){});
	    diseaseFactory.getListOfDiseases().then(function(response){
	      $scope.diseases = response.data.diseases;
	      console.log(response.data.diseases);
	      medicalRecordFactory.getListOfMedicalRecords().then(function(response){
		      $scope.medicalRecords = response.data.medicalRecords;
		      console.log(response.data.medicalRecords);
		      
		      $scope.diseases.sort(function(a, b){return a.id-b.id});
		      $scope.patients.sort(function(a, b){return a.id-b.id})
		      
		      $scope.medicalRecords.forEach(function(medR){
		        medR.diseaseIdList.sort();
		        var d;
		        var hold={ "firstname" : "No patient","lastname" : "No patient", "createdAt" : "","diseases" : []};
		        hold.createdAt = medR.createdAt;
		        
		        for(var i = d = 0; i < medR.diseaseIdList.length && d < $scope.diseases.length;){
		          if($scope.diseases[d].id == medR.diseaseIdList[i]){
		            hold.diseases.push($scope.diseases[d].name);
		            d++; i++;
		          }else{
		            ($scope.diseases[d].id > medR.diseaseIdList[i].id)?i++:d++;
		          }
		        }
		        
		        for(d = 0; d < $scope.patients.length && medR.patientId != $scope.patients[d].id; d++){}
		        if(d < $scope.patients.length){
		          hold.firstname = $scope.patients[d].firstname;
			      hold.lastname = $scope.patients[d].lastname;
		        }
		        
		        $scope.medRecs.push(hold);
		      });
		      console.log($scope.medRecs);
		    },function(){});
	    },function(){});
	    
	  };
	  
	  populate();
	}
  );