angular.module('hplus.modules.editmedicine')

  .controller('EditMedicineController',
    function($scope, $location, globalFactory, doctorFactory, medicineFactory, modalFactory){

      var user = doctorFactory.getUser();

      if(user != null) {
        if(!user.admin) {
          $location.path("/admin/list/record");
        }
      } else {
        $location.path("/");
      }

      $scope.medicine = medicineFactory.getMedicine();

      if($scope.medicine == null){
        $location.path('/admin/list/medicine');
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };

      var confirmUpdateMedicine = function() {
        medicineFactory.updateMedicine($scope.medicine);
      };
      
      $scope.updateMedicine = function(){
        modalObject = {
          type: "confirm",
          title: "Confirm Update",
          description: "Are you sure you want to update " + $scope.medicine.name + "?",
          negativeButton: "No",
          positiveButton: "Yes",
          isVisible: true,
          data: confirmUpdateMedicine
        };
      
        modalFactory.setContents(modalObject);
      };

      $scope.checkStatus = function(status){
        var retClass;

        if(status){
          retClass = "edit-button";
        } else {
          retClass = "delete-button";
        }

        return retClass;
      };

      $scope.delete = function(){
          medicineFactory.deleteMedicine($scope.medicine);
      };
      
      $scope.medicineTypes = [
        "Liquid", 
        "Tablet", 
        "Capsule", 
        "Topical Medicine", 
        "Suppository",
        "Drops",
        "Inhaler",
        "Injection",
        "Implant",
        "Patch",
        "Buccal or Sublingual Tablets"
      ];
    }
  );