require('./shared/header/header.main.js');
require('./shared/navbar/navbar.main.js');
require('./components/explorediseases/explorediseases.main.js');
require('./shared/footer/footer.main.js');
require('./components/registerdoctor/registerdoctor.main.js');
require('./components/viewdoctor/viewdoctor.main.js');

angular.module('hplus.modules', [
  'hplus.modules.header',
  'hplus.modules.navbar',
  'hplus.modules.explorediseases',
  'hplus.modules.footer',
  'hplus.modules.registerdoctor',
  'hplus.modules.viewdoctor'
]);

