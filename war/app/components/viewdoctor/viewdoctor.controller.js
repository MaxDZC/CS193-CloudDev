//angular.module('hplus.modules.viewdoctor')
app = angular.module('hplus.modules.viewdoctor');

  app.controller('ViewDoctorController',
    function($scope, globalFactory, doctorFactory){
		
		$scope.data = [];
		$scope.currentPage = 0;
		$scope.pageSize = 10;
		$scope.numberOfPages = function(){
          return Math.ceil($scope.data.length/$scope.pageSize);                
        }

      $scope.go = function(path){
        globalFactory.go(path);
      };
	  
	  $scope.doctor = {};
	  
      $scope.specialization = [
        {
          name: "Doe, Jane",
		  date: "Feb. 20, 2016",
		  disease: "Wisdom Tooth Eruption",
          id: 1
        },
        {
          name: "Phour, Mahn",
		  date: "June 19, 2015",
		  disease: "Gingivitis, Periodontitis, Dental Calculus",
          id: 2
        },
        {
          name: "Xing, Ah Mae",
		  date: "Mar. 3, 2015",
		  disease: "Malocclusion",
          id: 3
        },
		{
          name: "Williams, Andrew",
		  date: "Jan. 18, 2014",
		  disease: "Heart Failure, Kidney Cancer",
          id: 4
        },
		{
          name: "Adamwoods, Holi",
		  date: "June 9, 2014",
		  disease: "Liver Infection",
          id: 5
        },
		{
          name: "Armstrong, Rory",
		  date: "Mar. 3, 2015",
		  disease: "Body Pain, Stomachache",
          id: 6
        },
		{
          name: "Einstein, Albert",
		  date: "Mar. 18, 2013",
		  disease: "Malaria, Gingivitis, Blindness",
          id: 7
        },
		{
          name: "Rizal, Jose",
		  date: "Sept. 21, 2013",
		  disease: "Bleeding",
          id: 8
        },
		{
          name: "Rizal, Josie",
		  date: "Sept. 21, 2013",
		  disease: "Bleeding",
          id: 9
        },
		{
          name: "Rizal, John",
		  date: "Sept. 21, 2013",
		  disease: "Bleeding",
          id: 10
        },
		{
          name: "Rizal, Philip",
		  date: "Sept. 21, 2013",
		  disease: "Bleeding",
          id: 11
        }
      ];
		
	  $scope.makeTodos = function() {
			for (var i=0;i<11;i++) {
				var n = $scope.specialization[i].name;
				var da = $scope.specialization[i].date;
				var di = $scope.specialization[i].disease;
				console.log("",n);
				$scope.data.push({ 
				name: n,
				date: da,
				disease: di	
				});
			}
		};
		
		$scope.makeTodos();
	  
	  /*$scope.$watch('currentPage + numPerPage', function() {
      var begin = (($scope.currentPage - 1) * $scope.numPerPage)
    , end = begin + $scope.numPerPage;
   
      $scope.filteredTodos = $scope.todos.slice(begin, end);
      });
	  
	  var list = $scope.specialization[0];
	  console.log("",list);*/
	  
      $scope.registerDoctor = function(){
        doctorFactory.viewDoctor($scope.doctor);
      };
	  
    }
  );
  
  app.filter('startFrom', function() {
      return function(input, start) {
        start = +start; //parse to int
        return input.slice(start);
      }
  });