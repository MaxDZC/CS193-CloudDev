require('./shared/header/header.main.js');
require('./shared/navbar/navbar.main.js');
require('./shared/factory/app.factory.js');
require('./shared/modal/modal.main.js');

require('./components/editdisease/editdisease.main.js');

require('./components/editdoctor/editdoctor.main.js');
require('./components/editmedicine/editmedicine.main.js');

require('./components/createmedicalrecord/createmedicalrecord.main.js');
require('./components/explorediseases/explorediseases.main.js');
require('./components/exploredoctors/exploredoctors.main.js');
require('./components/exploremedicines/exploremedicines.main.js');
require('./components/exploremedicalrecords/exploremedicalrecords.main.js');

require('./components/registerdiseases/registerdiseases.main.js');
require('./components/registerdoctor/registerdoctor.main.js');
require('./components/registermedicine/registermedicine.main.js');
require('./components/registerpatient/registerpatient.main.js');
require('./components/login/login.main.js');
require('./components/viewdoctor/viewdoctor.main.js');
require('./components/viewdisease/viewdisease.main.js');
require('./components/viewmedicine/viewmedicine.main.js');
require('./components/viewmedicalrecord/viewmedicalrecord.main.js');
require('./components/viewpatient/viewpatient.main.js');
require('./components/resetpassword/resetpassword.main.js');

angular.module('hplus.modules', [
  'hplus.modules.header',
  'hplus.modules.navbar',
  'hplus.factory',
  'hplus.modules.createmedicalrecord',
  'hplus.modules.editdisease',
  'hplus.modules.editdoctor',
  'hplus.modules.editmedicine',
  'hplus.modules.explorediseases',
  'hplus.modules.exploredoctors',
  'hplus.modules.exploremedicines',
  'hplus.modules.exploremedicalrecords',
  'hplus.modules.login',
  'hplus.modules.modal',
  'hplus.modules.registerdiseases',
  'hplus.modules.registerdoctor',
  'hplus.modules.registermedicine',
  'hplus.modules.registerpatient',
  'hplus.modules.viewdisease',
  'hplus.modules.viewdoctor',
  'hplus.modules.viewmedicine',
  'hplus.modules.viewmedicalrecord',
  'hplus.modules.viewpatient',
  'hplus.modules.resetpassword'
]);

