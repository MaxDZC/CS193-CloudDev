package sample.service;
import sample.service.EmailService;
import sample.dao.DoctorDao;
import sample.dto.DoctorDto;
import sample.model.DoctorModel;



public class DoctorService {
    /**
     * Used to access the DAO functions for the DoctorModel
     */
    static DoctorDao doctorDao = new DoctorDao();
  
    //
    
    /**
     * Used to insert an item to the datastore
     * @param inputDoc - the dto that contains the data to be stored in the model object
     */
    public Boolean insertDoc(DoctorDto inputDoc){
        System.out.println("DoctorService.insertDoc start");
        
        DoctorModel doctorModel = new DoctorModel(inputDoc.getFirstName(),
                                                  inputDoc.getLastName(),
                                                  inputDoc.getAddress(),
                                                  inputDoc.getSpecialization(),
                                                  inputDoc.getContactNumber(),
                                                  inputDoc.getBirthDay(),
                                                  inputDoc.getUserName(),
                                                  inputDoc.getPassWord(),
                                                  inputDoc.getEmail()
                                                 );
        try{ 
            if(doctorDao.getDoc(doctorModel) == null){
                doctorDao.insertDoc(doctorModel);
                EmailService.send(inputDoc.getEmail(), "Your account is Created");
                    System.out.println(inputDoc.getEmail()+"Email sent!");                
            }else{
                System.out.println("Doctor Already Exists!");
                return false ;
            }
        }catch (Exception e){
            System.out.println("Exception in inserting doctor: "+e.toString());
        }
        
        System.out.println("DoctorService.insertDoc end");
        return true;
    }
    public Boolean updateDoctor(DoctorDto doctorDto) {
        System.out.println("ReportCardService.updateRecord " + "start");
        /**
         * ReportCardModel that will be stored to the datastore. 
         */
        DoctorModel doctorModel = storeDtoToModel(doctorDto);
        
        try {
            // checking if there is already the same item that exists in the datastore.
            DoctorModel resultModel = doctorDao.getCardByEmail(doctorModel);
            
            if (resultModel != null) {
                // setting the key in order to properly update the item
                doctorModel.setKey(resultModel.getKey());
                // update the entity to the datastore.
                DoctorService.doctorDao.updateDoctor(doctorModel);
                return true;
                
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
       
    }
    
    private DoctorModel storeDtoToModel(DoctorDto doctorDto) {
           
        DoctorModel doctorModel = new DoctorModel();
            
            // Storing the data from the DTO.
              doctorModel.setId(doctorDto.getId());
            doctorModel.setFirstName(doctorDto.getFirstName());
            doctorModel.setLastName(doctorDto.getLastName());
            doctorModel.setAddress(doctorDto.getAddress());
            doctorModel.setSpecialization(doctorDto.getSpecialization());
            doctorModel.setContactNumber(doctorDto.getContactNumber());
            doctorModel.setBirthDay(doctorDto.getBirthDay());
            doctorModel.setUserName(doctorDto.getUserName());
            doctorModel.setPassWord(doctorDto.getPassWord());
            
      
            System.out.println("ReportCardService.storeDtoToModel " + "end");
            
            // returning the model
            return doctorModel;
        
    }
    public static Object getDoctors() {
        // TODO Auto-generated method stub
        return doctorDao.getDoctors();
    }
}
