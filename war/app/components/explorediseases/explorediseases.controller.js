angular.module('hplus.modules.explorediseases')

  .controller('ExploreDiseasesController',
    function($scope, $location, globalFactory, doctorFactory, globalFactory, modalFactory, diseaseFactory, symptomFactory){

      var user = doctorFactory.getUser();

      if(user == null){
        $location.path("/");
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };
     
      $scope.searchFilter = "";
      
      $scope.diseases=[
        {
          "name" : "Tuberculosis",
          "symp" : ["Fever","chills","night sweats","loss of appetite","weight loss and fatigue"]
        },
        {
        	"name" : "Pneumonia",
            "symp" : ["Cough","fever","shaking chills","shortness of breath","chest pain"]
        }
      ];
      
      
      
      var populate = function(){
        diseaseFactory.getListOfDiseases().then(function(response){
          console.log(response); 
          
          $scope.diseases = response.data.diseases;
          var symptoms = [];
          
          symptomFactory.getListOfSymptoms().then(function(response){
            var symptomList = response.data.symptoms;
            console.log(symptomList);
            
            symptomList.sort(function(a, b){return a.id - b.id});
            
            $scope.diseases.forEach(function(dis){
              dis.symp = [];              
              dis.symptomId.sort(function(a, b){return a - b});
              var i,j;
              
              console.log("Sorted "+dis.symptomId);
              
              for(i = j = 0; i < dis.symptomId.length && j < symptomList.length;){
            	  console.log("compare "+dis.symptomId[i]+" TO "+symptomList[j].id +" IS ");
                if(dis.symptomId[i] == symptomList[j].id){
                  dis.symp.push(symptomList[j].name); 
                  i++; j++;
                }else{
                	(dis.symptomId[i] < symptomList[j].id)? i++ : j++;
                }
              }
              
            });
            },function(){});
        },function(){});
          
//          $scope.diseases.forEach(function(dis){
//            var hold = dis.symptomId;
//            
//            symptomFactory.getListOfSymptomsID(data).then(function(response){
//              console.log("symptomIDList: "+response.data.symptomIdList);
//              dis.symp = response.data.symptomIdList;
//            },function(){});
//            
//          });
//        }, function(response){
//          console.log(response.statusText);
//        });
      }
        
      populate();
    }
  );