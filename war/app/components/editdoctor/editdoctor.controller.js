angular.module('hplus.modules.editdoctor')

  .controller('EditDoctorController',
    function($scope, $location, globalFactory, doctorFactory, modalFactory){
    
      $scope.contactNoRegex = "\\d{6,}";

      var user = doctorFactory.getUser();
      var modalObject = null;

      if(user == null){
        $location.path("/");
      } else {
        if(user.admin){
          $scope.doctorData = doctorFactory.getDoctor();
        } else {
          $scope.doctorData = user;
        }
      }

      if($scope.doctorData == null){
        $location.path('/admin/list/doctor');
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };

      var confirmUpdateDoctor = function(){
        doctorFactory.updateDoctor($scope.doctorData);
      };

      $scope.checkStatus = function(status) {
        var retValue = "edit-button";

        if(status){
          retValue = "edit-button";
        } else {
          retValue = "delete-button";
        }

        return retValue;
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
      };

      $scope.delete = function(){
        doctorFactory.deleteDoctor($scope.doctorData);
      };
      
      $scope.specialization = [
        "Allergist",
        "Cardiologist",
        "Dermatologist",
        "Gastroenterologist",
        "Gynecologist",
        "Hematologist",
        "Internal Medicine Physician",
        "Nephrologist",
        "Neurologist",
        "Neurosurgeon",
        "Nurse-Midwifery",
        "Obstetrician",
        "Occupational Medicine Physician",
        "Oncologist",
        "Ophthalmologist",
        "Oral Surgeon",
        "Orthopaedic Surgeon",
        "Otolaryngologist",
        "Pathologist", 
        "Pediatrician", 
        "Plastic Surgeon",
        "Podiatrist",
        "Psychiatrist",
        "Pulmonary Medicine Physician",
        "Radiation Oncologist",
        "Diagnostic Radiologist",
        "Rheumatologist", 
        "Urologist"
      ];
    }
  );