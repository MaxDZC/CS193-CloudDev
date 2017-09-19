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
        
        doctorModel = new DoctorModel(inputDoc);
        
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
    
    public String updateDoctor(DoctorDto doctorDto) {
        System.out.println("DoctorService.updateRecord " + "start");
    
        String status;
        DoctorModel doctorModel, resultModel;
        
        doctorModel = new DoctorModel(doctorDto);
        
        status = "";
        
        try {
            if(doctorDao.checkDoctorUpdateEmail(doctorDto.getEmail(), doctorDto.getId())){
                status += "email"; 
            } else {
                // checking if there is already the same item that exists in the datastore.
                resultModel = (DoctorModel) doctorDao.getDoctorById(doctorDto.getId());
                
                // setting the key in order to properly update the item
                doctorModel.setKey(resultModel.getKey());
                // update the entity to the datastore.
                DoctorService.doctorDao.updateDoctor(doctorModel);        
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return status;
    }
    
    public String deleteDoctor(DoctorDto doctorDto) {
        System.out.println("DoctorService.deleteRecord " + "start");

        String state;
        DoctorModel resultModel;
        
        DoctorModel doctorModel = new DoctorModel(doctorDto);
        
        state = "";
        
        try { 
            // checking if there is already the same item that exists in the datastore.
            resultModel = (DoctorModel) doctorDao.getDoctorById(doctorDto.getId());
            
            if (resultModel != null) {
                // setting the key in order to properly delete the item
                doctorModel.setKey(resultModel.getKey());
               // doctorModel.setDeletedAt(new Date().toString());
                // delete the entity to the datastore.
                DoctorService.doctorDao.deleteDoctor(doctorModel);
            
                System.out.println("Deleted Doctor");
            } else {
                // deleting was canceled.
                state = "failed";
                System.out.println("There is no item with the same id.");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("DoctorService.deleteRecord " + "end");
        
        return state;
    }

    public static Object loginDoctor(String username, String password){
        System.out.println("DoctorService.loginDoctor");
        return doctorDao.getDoctorByEmailandPassword(username, password);
    }

    public static Object getDoctors() {
        return doctorDao.getDoctors();
    }
    public static Object getDoctor(Long id) {
        // TODO Auto-generated method stub
        return doctorDao.getDoctorById(id);
    }
}
