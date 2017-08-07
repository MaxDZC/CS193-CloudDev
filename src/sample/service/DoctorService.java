package sample.service;

import sample.dao.DoctorDao;
import sample.dto.DoctorDto;
import sample.model.DoctorModel;



public class DoctorService {
    /**
     * Used to access the DAO functions for the DoctorModel
     */
    DoctorDao doctorDao = new DoctorDao();
    //
    
    /**
     * Used to insert an item to the datastore
     * @param inputDoc - the dto that contains the data to be stored in the model object
     */
    public void insertDoc(DoctorDto inputDoc){
        System.out.println("DoctorService.insertDoc start");
        
        DoctorModel doctorModel = new DoctorModel(inputDoc.getFirstName(),
                                                  inputDoc.getLastName(),
                                                  inputDoc.getAddress(),
                                                  inputDoc.getSpecialization(),
                                                  inputDoc.getContactNumber(),
                                                  inputDoc.getBirthDay(),
                                                  inputDoc.getUserName(),
                                                  inputDoc.getPassWord()
                                                 );
        try{ //SendMail.main("rr");
            if(doctorDao.getDoc(doctorModel) == null){
                doctorDao.insertDoc(doctorModel);
                
            }else{
                System.out.println("Doctor Already Exists!");
            }
        }catch (Exception e){
            System.out.println("Exception in inserting doctor: "+e.toString());
        }
        
        System.out.println("DoctorService.insertDoc end");
    }
}
