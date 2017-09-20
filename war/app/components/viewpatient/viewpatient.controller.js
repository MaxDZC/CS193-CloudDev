app = angular.module('hplus.modules.viewpatient');

  app.controller('ViewPatientController',
    function($scope, globalFactory){
	  
      $scope.go = function(path){
        globalFactory.go(path);
      };
       
      $scope.patientData = {
        name: "Doe, Jane",
        sex: "female"
      };
      
       $scope.recordList = [
        {
    	 name: "Hyperacidity",
         symptoms:["Hot", "Cold", "Warm"],
         medicine: "Biogesic",
         dosage: "20mgx7",
         admissionDate: "February 20, 2016",
         dischargeDate: "February 21, 2016",
         bill: "308.00"
        },
        {
       	 name: "Heart Burn",
         symptoms:["Hot", "Cold", "Warm"],
         medicine: "Biogesic",
         dosage: "20mgx7",
         admissionDate: "February 20, 2016",
         dischargeDate: "February 21, 2016",
         bill: "400.00"
        },
        {
         name: "Osteoporosis",
         symptoms:["Hot", "Cold", "Warm"],
         medicine: "Biogesic",
         dosage: "20mgx7",
         admissionDate: "February 20, 2016",
         dischargeDate: "February 21, 2016",
         bill: "308.00"
        },
        {
         name: "Hyperacidity",
         symptoms:["Hot", "Cold", "Warm"],
         medicine: "Biogesic",
         dosage: "20mgx7",
         admissionDate: "February 20, 2016",
         dischargeDate: "February 21, 2016",
         bill: "308.00"
        },
        {
          name: "Hyperacidity",
          symptoms:["Hot", "Cold", "Warm"],
          medicine: "Biogesic",
          dosage: "20mgx7",
          admissionDate: "February 20, 2016",
          dischargeDate: "February 21, 2016",          
          bill: "308.00"
         },
         {
          name: "Hyperacidity",
          symptoms:["Hot", "Cold", "Warm"],
          medicine: "Biogesic",
          dosage: "20mgx7",
          admissionDate: "February 20, 2016",
          dischargeDate: "February 21, 2016",
          bill: "308.00"
        },
        {
          name: "Hyperacidity",
          symptoms:["Hot", "Cold", "Warm"],
          medicine: "Biogesic",
          dosage: "20mgx7",
          admissionDate: "February 20, 2016",
          dischargeDate: "February 21, 2016",
          bill: "308.00"
         },
         {
          name: "Hyperacidity",
          symptoms:["Hot", "Cold", "Warm"],
          medicine: "Biogesic",
          dosage: "20mgx7",
          admissionDate: "February 20, 2016",
          dischargeDate: "February 21, 2016",
          bill: "308.00"
         },
         {
          name: "Hyperacidity",
          symptoms:["Hot", "Cold", "Warm"],
          medicine: "Biogesic",
          dosage: "20mgx7",
          admissionDate: "February 20, 2016",
          dischargeDate: "February 21, 2016",
          bill: "308.00"
         },
         {
    	  name: "Hyperacidity",
          symptoms:["Hot", "Cold", "Warm"],
          medicine: "Biogesic",
          dosage: "20mgx7",
          admissionDate: "February 20, 2016",
          dischargeDate: "February 21, 2016",
          bill: "308.00"
         },
         {
          name: "Hyperacidity",
          symptoms:["Hot", "Cold", "Warm"],
          medicine: "Biogesic",
          dosage: "20mgx7",
          admissionDate: "February 20, 2016",
          dischargeDate: "February 21, 2016",
          bill: "308.00"
         }
      ];
  });