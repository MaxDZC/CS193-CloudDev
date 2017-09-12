angular.module('hplus.modules.exploremedicines')

  .controller('ExploreMedicinesController',
    function($scope, globalFactory){

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      $scope.selectedMedicine = null;
      
      $scope.setSelected = function(med){
    	  $scope.selectedMedicine = med;
      };
      
      $scope.medicines=[
        {
          name : "Metformin",
          desc : "Insert super long desc wooo amazing woawhe",
          price : 40000,
          treats :["Diabetes Mellitus"],
          id : 1
        },
        {
          name : "Methadone",
          desc : "Insert super long desc wooo amazing woawhe",
          price : 30000,
          treats :["Opioid dependency","chronic pain"],
          id : 2
        },
        {
          name : "Methampetamine",
          desc : "Methamphetamine is a strong central nervous system stimulant that is mainly used as a recreational drug and less commonly as a treatment for attention deficit hyperactivity disorder and obesity.",
          price : 24990,
          treats :["Attention deficit hyperactivity disorder","obesity"],
          id : 3
        },
        {
          name : "Methazolamide",
          desc : "For the sake of variety",
          price : 30000,
          treats :["Intraocular pressure in glaucoma"],
          id : 4
        },
      ];
    }
  );