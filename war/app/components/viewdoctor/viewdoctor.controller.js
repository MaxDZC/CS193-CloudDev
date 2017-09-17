angular.module('hplus.modules.viewdoctor')

  .controller('ViewDoctorController',
    function($scope, $location, globalFactory, doctorFactory, modalFactory){
    
      $scope.doctorData = doctorFactory.getDoctor();
      var modalObject;

      if($scope.doctorData == null){
        $location.path('/admin/list/doctor');
      }

      $scope.go = function(path){
        doctorFactory.saveDoctor($scope.doctorData);
        globalFactory.go(path);
      };

      var confirmDeleteDoctor = function(){
        console.log("deleted!" + $scope.doctorData.id);
      }

      $scope.confirmDelete = function(){
        if($scope.recordList.length == 0){
          modalObject = {
            type: "confirm",
            title: "Confirm Deleting",
            description: "Are you sure you want to delete " + $scope.doctorData.firstname + " " + $scope.doctorData.lastname + "?",
            negativeButton: "No",
            positiveButton: "Yes",
            isVisible: true,
            data: confirmDeleteDoctor,
            object: $scope.doctorData,
            clean: '/admin/list/doctor'
          };
      
          modalFactory.setContents(modalObject);
        } else {
          modalObject = {
            type: "notify",
            title: "Unable to Delete",
            description: "Dr. " + $scope.doctorData.firstname + " " + $scope.doctorData.lastname + " has pending medical records!",
            positiveButton: "Ok",
            isVisible: true
          };

          modalFactory.setContents(modalObject);
        }
      }

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