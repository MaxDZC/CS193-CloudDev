angular.module('hplus.modules.explorediseases')

  .controller('ExploreDiseasesController',
    function($scope, $location, globalFactory, doctorFactory, globalFactory, modalFactory, diseaseFactory, symptomFactory){

      $scope.user = doctorFactory.getUser();

      if($scope.user == null){
        $location.path("/");
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };
     
      $scope.query = "";
      
      var populate = function() {
        diseaseFactory.getListOfDiseases().then(function(response){
          console.log(response); 
          $scope.diseases = response.data.diseases;
          var medicalRecords = response.data.medicalRecords;

          var x, y, z;
          
          for(x = 0; x < $scope.diseases.length; x++) {
            for(y = 0; y < medicalRecords.length; y++) {
              for(z = 0; z < medicalRecords[y].diseaseIdList.length; z++) {
                if(medicalRecords[y].diseaseIdList[z] == $scope.diseases[x].id) {
                  if($scope.diseases[x].medicalRecords == null) {
                    $scope.diseases[x].medicalRecords = [];
                  }
                  $scope.diseases[x].medicalRecords.push(medicalRecords[y]);
                  z = medicalRecords[y].diseaseIdList.length;
                }
              } 
            }
          }

          var symptoms = [];
          
          symptomFactory.getListOfSymptoms().then(function(response){
            var symptomList = response.data.symptoms;
          
            symptomList.sort(function(a, b){return a.id - b.id});

            $scope.diseases.forEach(function(dis){
              dis.symp = [];              
              dis.symptomId.sort(function(a, b){return a - b});
              var i, j;
              
              for(i = j = 0; i < dis.symptomId.length && j < symptomList.length;){
                if(dis.symptomId[i] == symptomList[j].id) {
                  dis.symp.push(symptomList[j].name[0].toUpperCase() + symptomList[j].name.substr(1)); 
                  i++; j++;
                } else {
                	(dis.symptomId[i] < symptomList[j].id)? i++ : j++;
                }
              }
        
            });
            console.log($scope.diseases);
          });
        });
      };

      populate();
    
      $scope.searchFilter = function(disease){
        var retVal;

        if(!$scope.query 
        || (disease.name.toLowerCase().indexOf($scope.query) != -1)){
          retVal = true;
        } else {
          retVal = false;
        }

        return retVal;
      };
    
    }
  );