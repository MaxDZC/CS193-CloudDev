app = angular.module('hplus.modules.viewpatient');

  app.controller('ViewPatientController',
    function($scope, $location, globalFactory, doctorFactory, patientFactory){
	  
      var user = doctorFactory.getUser();
      var monthNames = ["January", "February", "March", "April", "May", "June",
      "July", "August", "September", "October", "November", "December"];

      if(user == null) {
        $location.path("/");
      }
	  
      $scope.patient = patientFactory.getPatient();
      var modalObject;

      if($scope.patient == null){
        $location.path('/admin/list/patient');
      } else {
        $scope.patient.name = $scope.patient.lastname + ", " + $scope.patient.firstname;

        var brokenDate = $scope.patient.birthday.split(" ");
        for(var i = 0; i < monthNames.length && $scope.patient.processedBirthday == null; i++){
          if(monthNames[i].indexOf(brokenDate[1]) != -1) {
            $scope.patient.processedBirthday = monthNames[i] + " " + (parseInt(brokenDate[2]) + 1) + ", " + brokenDate[5];
          }
        }

        $scope.patient.sexDisplay = ($scope.patient.sex) ? "Male" : "Female";
      }
	  
      $scope.go = function(path){
    	  patientFactory.savePatient($scope.patient);  
        globalFactory.go(path);
      };
      
      $scope.delete = function(){
        patientFactory.deletePatient($scope.patient);
      };
      
       $scope.recordList = [
        {
    	 name: "Hyperacidity",
         symptom:"Hot, Cold, Warm",
         medicine: "Biogesic",
         dosage: "20mgx7",
         admission: "February 20, 2016",
         discharge: "February 21, 2016",
         bill: "308.00"
        },
        {
       	 name: "Heart Burn",
         symptom:"Hot, Cold, Warm",
         medicine: "Biogesic",
         dosage: "20mgx7",
         admission: "February 20, 2016",
         discharge: "February 21, 2016",
         bill: "400.00"
        },
        {
         name: "Osteoporosis",
         symptom:"Hot, Cold, Warm",
         medicine: "Biogesic",
         dosage: "20mgx7",
         admission: "February 20, 2016",
         discharge: "February 21, 2016",
         bill: "308.00"
        },
        {
         name: "Hyperacidity",
         symptom:"Hot, Cold, Warm",
         medicine: "Biogesic",
         dosage: "20mgx7",
         admission: "February 20, 2016",
         discharge: "February 21, 2016",
         bill: "308.00"
        },
        {
          name: "Hyperacidity",
          symptom:"Hot, Cold, Warm",
          medicine: "Biogesic",
          dosage: "20mgx7",
          admission: "February 20, 2016",
          discharge: "February 21, 2016",          
          bill: "308.00"
         },
         {
          name: "Hyperacidity",
          symptom:"Hot, Cold, Warm",
          medicine: "Biogesic",
          dosage: "20mgx7",
          admission: "February 20, 2016",
          discharge: "February 21, 2016",
          bill: "308.00"
        },
        {
          name: "Hyperacidity",
          symptom:"Hot, Cold, Warm",
          medicine: "Biogesic",
          dosage: "20mgx7",
          admission: "February 20, 2016",
          discharge: "February 21, 2016",
          bill: "308.00"
         },
         {
          name: "Hyperacidity",
          symptom:"Hot, Cold, Warm",
          medicine: "Biogesic",
          dosage: "20mgx7",
          admission: "February 20, 2016",
          discharge: "February 21, 2016",
          bill: "308.00"
         },
         {
          name: "Hyperacidity",
          symptom:"Hot, Cold, Warm",
          medicine: "Biogesic",
          dosage: "20mgx7",
          admission: "February 20, 2016",
          discharge: "February 21, 2016",
          bill: "308.00"
         },
         {
    	  name: "Hyperacidity",
          symptom:"Hot, Cold, Warm",
          medicine: "Biogesic",
          dosage: "20mgx7",
          admission: "February 20, 2016",
          discharge: "February 21, 2016",
          bill: "308.00"
         },
         {
          name: "Hyperacidity",
          symptom:"Hot, Cold, Warm",
          medicine: "Biogesic",
          dosage: "20mgx7",
          admission: "February 20, 2016",
          discharge: "February 21, 2016",
          bill: "308.00"
         },
         {
          name: "Hyperacidity",
          symptom:"Hot, Cold, Warm",
          medicine: "Biogesic",
          dosage: "20mgx7",
          admission: "February 20, 2016",
          discharge: "February 21, 2016",
          bill: "308.00"
         }
      ];
  });