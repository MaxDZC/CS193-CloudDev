angular.module('hplus.modules.registermedicine')

  .controller('RegisterMedicineController',
    function($scope, $location, globalFactory, medicineFactory, doctorFactory, modalFactory){

      $scope.button = "Register";
      $scope.medicine = {};

      var user = doctorFactory.getUser();
      
      if(user != null) {
        if(!user.admin){
          $location.path("/admin/list/record");
        }
      } else {
        $location.path("/");
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };

      var clear = function(){
        $scope.medicine = {};
      };

      var confirmRegisterMedicine = function(){
        medicineFactory.registerMedicine($scope.medicine);
        clear();
      };
      
      $scope.registerMedicine = function(){
        var modalObject = {};
  
        if($scope.medicine.price >= 0){
          modalObject = {
            type: "confirm",
            title: "Confirm Registration",
            description: "Are you sure you want to register " + $scope.medicine.name + "?",
            negativeButton: "No",
            positiveButton: "Yes",
            isVisible: true,
            data: confirmRegisterMedicine
          };
        
          modalFactory.setContents(modalObject);
        } else {
          modalObject = {
            type: "notify",
            title: "Unable to register medicine!",
            description: "Price can't be negative!",
            positiveButton: "Ok",
            isVisible: true
          };
          
          modalFactory.setContents(modalObject);
        }

      };

      $scope.checkStatus = function(status){
        var retType;

        if(status) {
          $scope.button = "Register";
          retType = "edit-button";
        } else {
          $scope.button = "Please fill out all of the fields";
          retType = "delete-button";
        }

        return retType;
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
