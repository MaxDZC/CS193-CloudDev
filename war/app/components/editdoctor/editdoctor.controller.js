angular.module('hplus.modules.editdoctor')

  .controller('EditDoctorController',
    function($scope, $location, globalFactory, doctorFactory, modalFactory){
    
      $scope.doctorData = doctorFactory.getDoctor();
      var modalObject = null;

      if($scope.doctorData == null){
        $location.path('/admin/list/doctor');
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };

      var confirmUpdateDoctor = function(){
        doctorFactory.updateDoctor($scope.doctorData);
      };

      $scope.update = function(){
        modalObject = {
          type: "confirm",
          title: "Confirm Update",
          description: "Are you sure you want to update Dr. " + $scope.doctorData.lastname + "?",
          negativeButton: "No",
          positiveButton: "Yes",
          isVisible: true,
          data: confirmUpdateDoctor,
          object: $scope.doctorData,
          clean: '/admin/view/doctordetail'
        };
      
        modalFactory.setContents(modalObject);
      }
      
      $scope.specialization = [
        {
          name: "Cardiology",
          id: 1
        },
        {
          name: "Dentistry",
          id: 2
        },
        {
          name: "Nephrology",
          id: 3
        }
      ];
    }
  );