angular.module('hplus.modules.viewmedicalrecord')

  .filter('intersect', function() {
    return function(array1, array2) {
      return array1.filter(function (ar) {
        return this.indexOf(ar) !== -1;
      }, array2);
    };
  });