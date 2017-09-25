app = angular.module('hplus.modules.viewdisease')

  .controller('ViewDiseaseController',
    function($scope, $location, globalFactory, doctorFactory, diseaseFactory, medicineFactory){

      $scope.user = doctorFactory.getUser();
      $scope.disease = diseaseFactory.getDisease();

      var date = new Date();
      var monthNames = ["January", "February", "March", "April", "May", "June",
      "July", "August", "September", "October", "November", "December"];

      $scope.monthAndYear = monthNames[date.getMonth()].toUpperCase() + " " + date.getFullYear();
      $scope.year = date.getFullYear();

      if($scope.user == null) {
        $location.path("/");
      }

      if($scope.disease == null){
        $location.path("/admin/list/disease");
      } else {
        $scope.recordList = $scope.disease.medicalRecords;
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };

      var populate = function(){
        medicineFactory.getListOfMedicines().then(function(response){
          console.log(response);
          var medicineList = response.data.medicines;
          var meds = [];
          var x, y;

          for(x = 0; x < medicineList.length; x++){
            for(y = 0; y < $scope.disease.medicineId.length; y++){
              if(medicineList[x].id == $scope.disease.medicineId[y]){
                meds.push(medicineList[x].name);
              }
            }
          }

          $scope.disease.meds = meds;
        });
      };

      populate();

      $scope.delete = function(){
        diseaseFactory.deleteDisease($scope.disease);
      };
      
      $scope.recordList = [
           {
             name: "Doe, Jane",
             date: "Feb. 20, 2016",
             disease: "Heart Attack",
             id: 1
           },
           {
             name: "Rizal, Jose",
             date: "Apr. 10, 2013",
             disease: "Heart Attack",
             id: 2
           },
           {
             name: "Lietzkirg, Jaiyra",
             date: "May. 19, 2011",
             disease: "Heart Attack",
             id: 3
           },
           {
             name: "Doe, Jane",
             date: "Feb. 20, 2016",
             disease: "Heart Attack",
             id: 4
           },
           {
             name: "Doe, Jane",
             date: "Feb. 20, 2016",
             disease: "Heart Attack",
             id: 5
           },
           {
             name: "Doe, Jane",
             date: "Feb. 20, 2016",
             disease: "Heart Attack",
             id: 6
           },
           {
             name: "Doe, Jane",
             date: "Feb. 20, 2016",
             disease: "Heart Attack",
             id: 7
           },
           {
             name: "Doe, Jane",
             date: "Feb. 20, 2016",
             disease: "Heart Attack",
             id: 8
           },
           {
             name: "Doe, Jane",
             date: "Feb. 20, 2016",
             disease: "Heart Attack",
             id: 9
           },
           {
             name: "Doe, Jane",
             date: "Feb. 20, 2016",
             disease: "Heart Attack",
             id: 10
           },
           {
             name: "Doe, Jane",
             date: "Feb. 20, 2016",
             disease: "Heart Attack",
             id: 11
           }
         ];
    });