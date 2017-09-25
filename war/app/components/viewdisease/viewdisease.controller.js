app = angular.module('hplus.modules.viewdisease')

  .controller('ViewDiseaseController',
    function($scope, $location, globalFactory, doctorFactory, diseaseFactory, medicineFactory, patientFactory){

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

        $scope.monthUsage = 0;
        $scope.yearUsage = 0;
        
        patientFactory.getListOfPatients().then(function(response){
          console.log(response);
          var patientList = response.data.patients;
          var x, y;

          for(x = 0; x < $scope.recordList.length; x++) {
            for(y = 0; y < patientList.length && $scope.recordList[x].name == null; y++) {
              if($scope.recordList[x].patientId == patientList[y].id){
                $scope.recordList[x].name = patientList[y].lastname + ", " + patientList[y].firstname;

                var date = $scope.recordList[x].createdAt.split(" ");

                for(var i = 0; i < monthNames.length && $scope.recordList[x].date == null; i++) {
                  if(monthNames[i].indexOf(date[1]) != -1) {
                    realDate = new Date(date[5], (i + 1), parseInt(date[2]) + 1);

                    if($scope.monthAndYear.toLowerCase().indexOf(monthNames[i].toLowerCase()) != -1) {
                      $scope.yearUsage++;
                      $scope.monthUsage++;
                    } else if(date[5] == $scope.year) {
                      $scope.yearUsage++;
                    }

                    $scope.recordList[x].date = monthNames[i].substr(0, 3);
                    if(monthNames[i].length > 3){
                      $scope.recordList[x].date += ".";
                    }
                    $scope.recordList[x].date += " " + realDate.getDate() + ", " + realDate.getFullYear();
                  }
                }
              }
            }
          }
        });

        doctorFactory.getListOfDoctors().then(function(response){
          console.log(response);
          var doctorList = response.data.doctors;
          var x, y;

          for(x = 0; x < $scope.recordList.length; x++) {
            for(y = 0; y < doctorList.length && $scope.recordList[x].doctor == null; y++) {
              if($scope.recordList[x].doctorId == doctorList[y].id) {
                $scope.recordList[x].doctor = doctorList[y].firstname + " " + doctorList[y].lastname;
                $scope.recordList[x].doctorId = doctorList[y].id;
              }
            }
          }
        });
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
    });