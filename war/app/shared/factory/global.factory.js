angular.module('hplus.factory')

  .factory('globalFactory', 
    function($location){
      
      var go = function(path){
        $location.path(path);
      };

      return{
        go: go
      };
    }
  );