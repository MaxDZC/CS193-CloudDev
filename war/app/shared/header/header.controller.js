angular.module('hplus.modules.header')

  .controller('HeaderController',
    function($scope, $location, globalFactory, doctorFactory) {

      $scope.user = doctorFactory.getUser();

      $scope.$on("userLoggedIn", function(event, user) {
        $scope.user = user;
      });

      $scope.logout = function() {
        doctorFactory.logout();
        $scope.user = null;
      };

      $scope.go = function(path) {
        globalFactory.go(path);
      };

      $scope.viewProfile = function(path) {
        doctorFactory.saveDoctor($scope.user);

        if($location.path() != "/admin/view/doctordetails"){
          globalFactory.go(path);
        } else {
          doctorFactory.updateView();
        }
      };
    }
  );