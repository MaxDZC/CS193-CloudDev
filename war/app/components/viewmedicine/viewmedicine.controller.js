app = angular.module('hplus.modules.viewmedicine');

  app.controller('ViewMedicineController',
    function($scope, globalFactory){
	    
	$scope.data = [];
	$scope.currentPage = 0;
	$scope.pageSize = 10;
	$scope.numberOfPages = function(){
          return Math.ceil($scope.data.length/$scope.pageSize);                
        }

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
       $scope.record = [
        {
          name: "Doe, Jane",
	  date: "Feb. 20, 2016",
	  doctor: "Dr. John Appleseed",
          id: 1
        },
        {
          name: "Rizal, Jose",
	  date: "Apr. 10, 2013",
	  doctor: "Dr. John Appleseed",
          id: 2
        },
        {
          name: "Lietzkirg, Jaiyra",
	  date: "May. 19, 2011",
	  doctor: "Dr. John Appleseed",
          id: 3
        },
	{
          name: "Doe, Jane",
	  date: "Feb. 20, 2016",
	  doctor: "Dr. John Appleseed",
          id: 4
        },
	{
          name: "Doe, Jane",
	  date: "Feb. 20, 2016",
	  doctor: "Dr. John Appleseed",
          id: 5
        },
	{
          name: "Doe, Jane",
	  date: "Feb. 20, 2016",
	  doctor: "Dr. John Appleseed",
          id: 6
        },
	{
          name: "Doe, Jane",
	  date: "Feb. 20, 2016",
	  doctor: "Dr. John Appleseed",
          id: 7
        },
	{
          name: "Doe, Jane",
	  date: "Feb. 20, 2016",
	  doctor: "Dr. John Appleseed",
          id: 8
        },
	{
          name: "Doe, Jane",
	  date: "Feb. 20, 2016",
	  doctor: "Dr. John Appleseed",
          id: 9
        },
	{
          name: "Doe, Jane",
	  date: "Feb. 20, 2016",
	  doctor: "Dr. John Appleseed",
          id: 10
        },
	{
          name: "Doe, Jane",
	  date: "Feb. 20, 2016",
	  doctor: "Dr. John Appleseed",
          id: 11
        }
      ];
      $scope.makeTodos = function() {
        for (var i=0;i<11;i++) {
	  var n = $scope.record[i].name;
	  var da = $scope.record[i].date;
	  var di = $scope.record[i].doctor;
	  console.log("",n);
	  $scope.data.push({ 
	  name: n,
	  date: da,
	  doctor: di	
	  });
	}
      };
      $scope.makeTodos();
    }
  );
  
  app.filter('startFrom', function() {
      return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
      }
  });