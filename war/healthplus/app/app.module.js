require('./shared/header/header.main.js');
require('./shared/navbar/navbar.main.js');

require('./shared/parts/modal/modal.main.js');

require('./components/editdisease/editdisease.main.js');
require('./components/editdoctor/editdoctor.main.js');
require('./components/editmedicine/editmedicine.main.js');

require('./components/explorediseases/explorediseases.main.js');
require('./components/exploredoctors/exploredoctors.main.js');
require('./components/exploremedicines/exploremedicines.main.js');
require('./components/exploremedicalrecords/exploremedicalrecords.main.js');

require('./components/registerdiseases/registerdiseases.main.js');
require('./components/registerdoctor/registerdoctor.main.js');
require('./components/registermedicine/registermedicine.main.js');
require('./components/userLogin/loginForm.main.js');
require('./components/viewdoctor/viewdoctor.main.js');

angular.module('hplus.modules', [
  'hplus.modules.header',
  'hplus.modules.navbar',
  'hplus.modules.editdisease',
  'hplus.modules.editdoctor',
  'hplus.modules.editmedicine',
  'hplus.modules.explorediseases',
  'hplus.modules.exploredoctors',
  'hplus.modules.exploremedicines',
  'hplus.modules.exploremedicalrecords',
  'hplus.modules.modal',
  'hplus.modules.registerdiseases',
  'hplus.modules.registerdoctor',
  'hplus.modules.registermedicine',
  'hplus.modules.userLogin',
  'hplus.modules.viewdoctor'
]);
