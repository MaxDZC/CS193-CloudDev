angular.module('hplus.modules.modal')

  .controller('ModalController',
    function($scope, globalFactory){

      $scope.modalContents = {
        title: "Totally save changes",
        description: "Are you sure you want to save changes?"
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );