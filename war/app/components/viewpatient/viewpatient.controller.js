app = angular.module('hplus.modules.viewpatient');

  app.controller('ViewPatientController',
    function($scope, $location, globalFactory, doctorFactory, patientFactory){
	  
	  var user = doctorFactory.getUser();

      if(user == null) {
        $location.path("/");
      }
	  
	  $scope.patientData = patientFactory.getPatient();
      var modalObject;

      if($scope.patientData == null){
        //$location.path('/admin/list/patient');
      }
	  
      $scope.go = function(path){
    	patientFactory.savePatient($scope.patientData);  
        globalFactory.go(path);
      };
      
      $scope.delete = function(){
        patientFactory.deletePatient($scope.patientData);
      };
      
      
       
      $scope.patientData = {
        name: "Doe, Jane",
        sex: "female"
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