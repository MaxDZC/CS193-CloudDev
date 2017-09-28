angular.module('hplus.factory')

  .factory('modalFactory', 
    function($http, $rootScope){

      var modalContents = {}

      var setContents = function(passedObject){
        modalContents = passedObject;
        $rootScope.$broadcast('modalReceived', modalContents);
      }

      var getContents = function(){
        return modalContents;
      }
      
      return {
        setContents: setContents,
        getContents: getContents
      }
    }
  );