angular.module('hplus.modules.navbar')

  .controller('NavbarController',
    function($scope, $location, globalFactory){

      $scope.registerButton = "Register Disease";
      $scope.link = "#!/admin/register/disease";

      $scope.checkPage = function(){
        var state = true;

        if($location.path() == "/admin/register/doctor"){
          state = false;
        } else if($location.path() == "/admin/list/doctor"){
          $scope.registerButton = "Register Doctor";
          $scope.link = "#!/admin/register/doctor";
        }

        return state;
      }

      $scope.selected = function(page){
        var currLoc = $location.path();
        var btnClass = "navbar__btn";

        if(currLoc.indexOf(page) != -1){
          btnClass += " navbar__btn--selected";
        }

        return btnClass;
      }

      $scope.go = function(path){
        globalFactory.go(path);
      };
    }
  );