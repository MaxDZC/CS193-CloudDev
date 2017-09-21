app = angular.module('hplus.modules.viewmedicine')

  .controller('ViewMedicineController',
    function($scope, $location, globalFactory, doctorFactory, medicineFactory){

      var user = doctorFactory.getUser();
      var date = new Date();
      var monthNames = ["January", "February", "March", "April", "May", "June",
      "July", "August", "September", "October", "November", "December"];

      $scope.medicine = medicineFactory.getMedicine();
      $scope.monthAndYear = monthNames[date.getMonth()].toUpperCase() + " " + date.getFullYear();
      $scope.year = date.getFullYear();

      if(user == null) {
        $location.path("/");
      }

      var modalObject;

      if($scope.medicine == null){
        $location.path('/admin/list/medicine');
      }
	  
      $scope.go = function(path) {
    	  medicineFactory.saveMedicine($scope.medicine);
        globalFactory.go(path);
      };
      
      $scope.delete = function(){
        medicineFactory.deleteMedicine($scope.medicine);
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