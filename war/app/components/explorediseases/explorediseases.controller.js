angular.module('hplus.modules.explorediseases')

  .controller('ExploreDiseasesController',
    function($scope, globalFactory){
     
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
    }
  );