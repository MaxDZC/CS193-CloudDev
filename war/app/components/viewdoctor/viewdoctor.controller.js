angular.module('hplus.modules.viewdoctor')

  .controller('ViewDoctorController',
    function($scope, $location, $timeout, globalFactory, doctorFactory, modalFactory){
    
      $scope.user = doctorFactory.getUser();

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

      $scope.recordList = [
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

      $scope.recordList = [];
  });