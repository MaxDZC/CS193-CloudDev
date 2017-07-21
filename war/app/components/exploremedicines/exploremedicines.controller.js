angular.module('hplus.modules.exploremedicines')

  .controller('ExploreMedicinesController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );