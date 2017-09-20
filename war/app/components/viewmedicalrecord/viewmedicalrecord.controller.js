angular.module('hplus.modules.viewmedicalrecord')

  .controller('ViewMedicalRecordController',
    function($scope, globalFactory, medicalRecordFactory){
	  $scope.record = {
        "symptoms" : [],
        "diseases" : [],
        "medicines" : [],
        "quantity" : [ 7 , 21],
        "dischargeDate" : "2018-01-05T09:05:05.035Z",
        "createdAt" : "2016-02-20T09:05:05.035Z"
	  };
	  
	  $scope.diseases = ["Hyperacidity","Trichotrillomania"];
	  
	  $scope.symptoms = ["Lack of appetite","Constipation","Indigestion","Sour Belching","Vomiting","Repeatedly pulling hair out","Noticeable hair loss","Low self-esteem"];
	  
      $scope.patient = {
        "firstName" : "Jane",
        "lastName" : "Doe",
        "dateOfBirth" : "1970-01-01T09:05:05.035Z",
        "sex" : false
      };
      
      $scope.sex = ($scope.patient.sex)? "Male" : "Female";
      
      $scope.medicines =[
        {
          "name" : "Omeprazole 20mg",
          "price" : 44
        },
        {
          "name" : "Clomipramine 25mg",
          "price" : 55
        }
      ];
      
      $scope.totalBill = 0;
      $scope.medicines.forEach(function(med,i){
        $scope.totalBill += med.price * $scope.record.quantity[i]; 
      });
    }
  );