angular.module('hplus.modules.exploremedicines')

  .controller('ExploreMedicinesController',
    function($scope, $location, globalFactory, doctorFactory, medicineFactory){

      $scope.length = 0;
      $scope.selectedMedicine = null;

      var user = doctorFactory.getUser();

      if(user == null){
        $location.path("/");
      }

      var populate = function(){
        medicineFactory.getListOfMedicines().then(function(response){
          console.log(response);
          $scope.medicineList = response.data.medicines;
          $scope.length = $scope.medicineList.length;
        }, function(response){
          console.log(response);
        });
      };

      populate();

      $scope.go = function(path){
        globalFactory.go(path);
      };
      
      
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
        {
          name : "Shit",
          desc : "New York can i shit, i got lots of shit to sa i got lots of shit to say oooohhhhhhhh, i cant fir mt hand inside a pringle can, i have a huge amount of trouble",
          price : 30000,
          treats :["Intraocular pressure in glaucoma"],
          id : 5
        },
        {
          name : "LookATALllthishands",
          desc : "Pringle Cans. you hink you can i know u can PRINGLES listen to the people im sure 80% of your complaint letters are about the width of your cans.just. make them wider. Thatis priority numero uno. i dont go to the gym because im self conscious about my body. but im self conscious about my body cuz i dont go the gym. irony can be so painful",
          price : 30000,
          treats :["Chicken Burrito, BRAH"],
          id : 6
        },
        {
          name : "ItWouldntFIt",
          desc : "Half of it half of it. i think its time that we break it down.... WAoooww. waooowwwwwwww. waaaaaooooooowwwwwwwww. buluulululul. I can sit here and preend that my biggest ropblems are pringle cans and burritos. but my bbiggetsp roblem is you. but i wanna ",
          price : 30000,
          treats :["Chicken Burrito, BRAH"],
          id : 7
        },
        {
          name : "Shit",
          desc : "New York can i shit, i got lots of shit to sa i got lots of shit to say oooohhhhhhhh, i cant fir mt hand inside a pringle can, i have a huge amount of trouble",
          price : 30000,
          treats :["Intraocular pressure in glaucoma"],
          id : 8
        },
        {
          name : "LookATALllthishands",
          desc : "Pringle Cans. you hink you can i know u can PRINGLES listen to the people im sure 80% of your complaint letters are about the width of your cans.just. make them wider. Thatis priority numero uno. i dont go to the gym because im self conscious about my body. but im self conscious about my body cuz i dont go the gym. irony can be so painful",
          price : 30000,
          treats :["Chicken Burrito, BRAH"],
          id : 9
        },
        {
          name : "ItWouldntFIt",
          desc : "Half of it half of it. i think its time that we break it down.... WAoooww. waooowwwwwwww. waaaaaooooooowwwwwwwww. buluulululul. I can sit here and preend that my biggest ropblems are pringle cans and burritos. but my bbiggetsp roblem is you. but i wanna ",
          price : 30000,
          treats :["Chicken Burrito, BRAH"],
          id : 10
        },
        {
          name : "Wouldntagotthelettuce",
          desc : "They dont need to know the half of this right now. If they still dont understand you thenee yourun it one more time AAAH",
          price : 30000,
          treats :["RIGHT NOW"],
          id : 11
        }
      ];
    }
  );