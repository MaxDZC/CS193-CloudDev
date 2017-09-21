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
          $scope.diseases.forEach(function(dis){
            dis.symp = [];
            dis.symptomId.forEach(function(symp){
              var data={ "id" : symp};
              symptomFactory.getSymptom(data).then(function(){
                console.log(response);
                if(response.data.symptom != null){
                	dis.symp.push(response.data.symptom);
                }
              }
              ,function(){
                console.log("Error Getting Symptom");
              });
            }); 
          });
        }, function(response){
          console.log(response.statusText);
        });
      }
        
      populate();
    }
  );