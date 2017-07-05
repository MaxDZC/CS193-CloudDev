require('./shared/header/header.main.js');
require('./shared/navbar/navbar.main.js');
require('./components/explorediseases/explorediseases.main.js');
require('./shared/footer/footer.main.js');
require('./components/registerdoctor/registerdoctor.main.js');
require('./components/registerdiseases/registerdiseases.main.js');
require('./components/registermedicine/registermedicine.main.js');
require('./components/viewdoctor/viewdoctor.main.js');
require('./components/viewmedicine/viewmedicine.main.js');
require('./components/editdoctor/editdoctor.main.js');
require('./components/exploredoctors/exploredoctors.main.js');
require('./components/exploremedicines/exploremedicines.main.js');
require('./components/userLogin/loginForm.main.js');
require('./shared/parts/pagination/pagination.main.js');

require('./components/createmedicalrecord/createmedicalrecord.main.js');

require('./shared/parts/modal/modal.main.js');
require('./components/editdisease/editdisease.main.js');
require('./components/editmedicine/editmedicine.main.js');
angular.module('hplus.modules', [
  'hplus.modules.header',
  'hplus.modules.navbar',
  'hplus.modules.explorediseases',
  'hplus.modules.registerdoctor',
  'hplus.modules.registerdiseases',
  'hplus.modules.registermedicine',
  'hplus.modules.footer',
  'hplus.modules.viewdoctor',
  'hplus.modules.viewmedicine',
  'hplus.modules.editdoctor',
  'hplus.modules.editmedicine',
  'hplus.modules.editdisease',
  'hplus.modules.exploredoctors',
  'hplus.modules.exploremedicines',
  'hplus.modules.userLogin',
  'hplus.modules.createmedicalrecord',
  'hplus.modules.pagination'
]);

