app = angular.module('hplus.modules.viewmedicine')

  .controller('ViewMedicineController',
    function($scope, $location, globalFactory, doctorFactory, medicineFactory, patientFactory){

      $scope.user = doctorFactory.getUser();
      var date = new Date();
      var monthNames = ["January", "February", "March", "April", "May", "June",
      "July", "August", "September", "October", "November", "December"];

      $scope.medicine = medicineFactory.getMedicine();
      $scope.monthAndYear = monthNames[date.getMonth()].toUpperCase() + " " + date.getFullYear();
      $scope.year = date.getFullYear();

      if($scope.user == null) {
        $location.path("/");
      }

      var modalObject;

      if($scope.medicine == null){
        $location.path('/admin/list/medicine');
      } else {
        $scope.recordList = $scope.medicine.medicalRecords;
        console.log($scope.recordList);
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
	  
      $scope.go = function(path) {
    	  medicineFactory.saveMedicine($scope.medicine);
        globalFactory.go(path);
      };
      
      $scope.delete = function(){
        medicineFactory.deleteMedicine($scope.medicine);
      };
      
 /*      $scope.recordList = [
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
      */
  });