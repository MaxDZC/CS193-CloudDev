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
    
    /**
     * Used to insert an item to the datastore
     * @param inputDoc - the dto that contains the data to be stored in the model object
     */
    public String insertDoc(DoctorDto inputDoc){
        System.out.println("DoctorService.insertDoc start");
        
        String status;
        DoctorModel doctorModel;
        
        
        doctorModel = new DoctorModel();
        status = doctorDao.validateDoctor(inputDoc);
        
        try { 
            if(status.equals("")){
                doctorDao.insertDoc(doctorModel);
                
                EmailService.send(inputDoc.getEmail(), "Your account is Created");
                    System.out.println(inputDoc.getEmail()+"Email sent!");              
            } else {
                System.out.println("Doctor Already Exists!");
            }
        }catch (Exception e){
            System.out.println("Exception in inserting doctor: "+e.toString());
        }
        
        System.out.println("DoctorService.insertDoc end");
        
        return status;
    }
    
    public static  Boolean updateDoctor(DoctorDto doctorDto) {
        System.out.println("DoctorService.updateRecord " + "start");
    
        DoctorModel doctorModel = storeDtoToModel(doctorDto);
        
        try {
            // checking if there is already the same item that exists in the datastore.
            DoctorModel resultModel = (DoctorModel) doctorDao.getDoctorById(doctorModel.getId());
            
            if (resultModel != null) {
                // setting the key in order to properly update the item
                doctorModel.setKey(resultModel.getKey());
               // doctorModel.setUpdatedAt(new Date().toString());
                // update the entity to the datastore.
                DoctorService.doctorDao.updateDoctor(doctorModel);
                return true;
                
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
       
    }
    public static Boolean deleteDoctor(DoctorDto doctorDto) {
        System.out.println("DoctorService.deleteRecord " + "start");
        /**
         * DoctorModel that will be stored to the datastore. 
         */
        DoctorModel doctorModel = storeDtoToModel(doctorDto);
        
        try { 
            // checking if there is already the same item that exists in the datastore.
            DoctorModel resultModel = (DoctorModel) doctorDao.getDoctorById(doctorDto.getId());
            
            if (resultModel != null) {
                // setting the key in order to properly delete the item
                doctorModel.setKey(resultModel.getKey());
               // doctorModel.setDeletedAt(new Date().toString());
                // delete the entity to the datastore.
                DoctorService.doctorDao.deleteDoctor(doctorModel);
            
                System.out.println("Deleted Doctor");
                return true ;
            } else {
                // deleting was canceled.
                System.out.println("There is no item with the same id.");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("DoctorService.deleteRecord " + "end");
        return false;
    }
    private static DoctorModel storeDtoToModel(DoctorDto doctorDto) {
           
        DoctorModel doctorModel = new DoctorModel();
            
            // Storing the data from the DTO.
            doctorModel.setId(doctorDto.getId());
            doctorModel.setFirstName(doctorDto.getFirstName());
            doctorModel.setLastName(doctorDto.getLastName());
            doctorModel.setAddress(doctorDto.getAddress());
            doctorModel.setSpecialization(doctorDto.getSpecialization());
           // doctorModel.setContactNumber(doctorDto.getContactNumber());
           // doctorModel.setBirthDay(doctorDto.getBirthDay());
           // doctorModel.setUserName(doctorDto.getUserName());
           // doctorModel.setPassWord(doctorDto.getPassWord());           
      
            System.out.println("DoctorService.storeDtoToModel " + "end");
            
            // returning the model
            return doctorModel;
        
    }
    public static DoctorModel loginDoctor(String username, String password){
        System.out.println("SERVICEE");
        DoctorModel  doctor = doctorDao.getDoctorByEmailandPassword(username, password);
        return doctor;
    }
    public static Object getDoctors() {
        // TODO Auto-generated method stub
        return doctorDao.getDoctors();
    }
    public static Object getDoctor(Long id) {
        // TODO Auto-generated method stub
        return doctorDao.getDoctorById(id);
    }
}
