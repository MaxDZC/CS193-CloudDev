angular.module('hplus.modules.viewdoctor')

  .controller('ViewDoctorController',
    function($scope, $location, $timeout, globalFactory, doctorFactory, modalFactory, patientFactory, diseaseFactory){
    
      $scope.user = doctorFactory.getUser();
      var monthNames = ["January", "February", "March", "April", "May", "June",
      "July", "August", "September", "October", "November", "December"];

      if($scope.user != null) {
        if($scope.user.admin){
          $scope.doctorData = doctorFactory.getDoctor();
        } else {
          $scope.doctorData = $scope.user;
        }
      } else {
        $location.path("/");
      }

      var modalObject;

      if($scope.doctorData == null) {
        $location.path('/admin/list/doctor');
      } else {
        console.log($scope.doctorData);
        var brokenDate = $scope.doctorData.birthday.split(" ");
        var realDate;

        for(var i = 0; i < monthNames.length && $scope.doctorData.processedBirthday == null; i++){
          if(monthNames[i].indexOf(brokenDate[1]) != -1) {
            realDate = new Date(brokenDate[5], (i + 1), parseInt(brokenDate[2]) + 1);
            $scope.doctorData.processedBirthday = monthNames[i] + " " + realDate.getDate() + ", " + realDate.getFullYear();
          }
        }

        $scope.recordList = $scope.doctorData.medicalRecords;

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

        diseaseFactory.getListOfDiseases().then(function(response){
          console.log(response); 
          console.log($scope.recordList);
          var diseaseList = response.data.diseases;
          var x, y, z;

          for(x = 0; x < $scope.recordList.length; x++) {
            var disease = "";
            for(y = 0; y < $scope.recordList[x].diseaseIdList.length; y++) {
              for(z = 0; z < diseaseList.length; z++) {
                if($scope.recordList[x].diseaseIdList[y] == diseaseList[z].id) {
                  if(disease == "") {
                    disease = diseaseList[z].name[0].toUpperCase() + diseaseList[z].name.substr(1);
                  } else {
                    disease +=", " + diseaseList[z].name[0].toUpperCase() + diseaseList[z].name.substr(1);
                  }
                }
              }
            }
            $scope.recordList[x].disease = disease;
          }


        });

      }

      $scope.$on("updateProfile", function(event) {
        $scope.doctorData = doctorFactory.getUser();
      });

      $scope.go = function(path){
        doctorFactory.saveDoctor($scope.doctorData);
        globalFactory.go(path);
      };

      $scope.delete = function(){
        doctorFactory.deleteDoctor($scope.doctorData);
      };
  });