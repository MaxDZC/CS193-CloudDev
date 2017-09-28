angular.module('hplus.modules.exploremedicalrecords')

  .controller('ExploreMedicalRecordsController',
	function($scope, $location, globalFactory, doctorFactory, patientFactory, medicalRecordFactory, diseaseFactory){

		$scope.user = doctorFactory.getUser();
		var monthNames = ["January", "February", "March", "April", "May", "June",
		"July", "August", "September", "October", "November", "December"];

		if($scope.user == null){
			$location.path("/");
		}
		
	  $scope.go = function(path){
			globalFactory.go(path);
	  };
	  
	  $scope.medRecs =[];
	  
	  $scope.medicalRecords = [];
	  
	  var populate = function(){
	    console.log("medFactoryStart");
	    patientFactory.getListOfPatients().then(function(response){
	      $scope.patients = response.data.patients;
	      console.log(response.data.patients);
	    });
	    diseaseFactory.getListOfDiseases().then(function(response){
	      $scope.diseases = response.data.diseases;
	      console.log(response.data.diseases);
	      medicalRecordFactory.getListOfMedicalRecords().then(function(response){
		      $scope.medicalRecords = response.data.medicalRecords;
		      console.log(response.data.medicalRecords);
		      
		      $scope.diseases.sort(function(a, b){return a.id-b.id});
		      $scope.patients.sort(function(a, b){return a.id-b.id})
		      
		      $scope.medicalRecords.forEach(function(medR) {
		        medR.diseaseIdList.sort();
		        var d;
						var hold={ "firstname" : "No patient","lastname" : "No patient", "createdAt" : "","diseases" : [], "discharged" : "" };
						var date = medR.createdAt.split(" ");
						var discharged = medR.dischargeDate.split(" ");
						var tempDate = null;
						var tempDischarged = null;
						var realDate;

						for(var i = 0; i < monthNames.length && (tempDate == null || tempDischarged == null); i++) {
							if(monthNames[i].indexOf(date[1]) != -1) {
								realDate = new Date(date[5], (i + 1), parseInt(date[2]) + 1);

								tempDate = monthNames[i].substr(0, 3);
								if(monthNames[i].length > 3){
									tempDate += ".";
								}
								tempDate += " " + realDate.getDate() + ", " + realDate.getFullYear();
							}
							if(monthNames[i].indexOf(discharged[1]) != -1) {
								realDate = new Date(discharged[5], i, parseInt(discharged[2]) + 1);
								
								console.log(new Date());
								console.log(realDate);
								if(new Date() < realDate) {
									tempDischarged = false;
								} else {
									tempDischarged = true;
								}
							}
						}

						hold.createdAt = tempDate;
						hold.discharged = tempDischarged;
		        
		        for(var i = d = 0; i < medR.diseaseIdList.length && d < $scope.diseases.length;){
		          if($scope.diseases[d].id == medR.diseaseIdList[i]){
		            hold.diseases.push($scope.diseases[d].name[0].toUpperCase() + $scope.diseases[d].name.substr(1));
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
		
		$scope.searchFilter = function(medicalRecord){
			if(!$scope.query 
			|| (medicalRecord.firstname.toLowerCase().indexOf($scope.query) != -1)
			|| (medicalRecord.lastname.toLowerCase().indexOf($scope.query) != -1)){
				return true;
			} else {
				return false;
			}
		};
	}
);