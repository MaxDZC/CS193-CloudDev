angular.module('hplus.modules.header')

  .controller('HeaderController',
    function($scope, globalFactory,$rootScope){
          
      $scope.$on('loginUserContents', function(event, users) {
        $scope.currUser = users;
      });
    	    	
    	console.log($scope.currUser);
      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );