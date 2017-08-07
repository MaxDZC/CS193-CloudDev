package sample.service;

import sample.dao.PatientDao;
import sample.dto.PatientDto;
import sample.model.PatientModel;


public class PatientService {
    /**
     * Used to access the DAO functions for the PatientModel
     */
    PatientDao PatientDao = new PatientDao();
    
    /**
     * Used to insert an item to the datastore
     * @param inputPat - the dto that contains the data to be stored in the model object
     */
    public void insertPat(PatientDto inputPat){
        System.out.println("PatientService.insertPat start");
        
        PatientModel PatientModel = new PatientModel(inputPat.getFirstName(),
                                                  inputPat.getLastName(),
                                                  inputPat.getAddress(),
                                                  inputPat.getSpecialization(),
                                                  inputPat.getContactNumber(),
                                                  inputPat.getBirthDay(),
                                                  inputPat.getUserName(),
                                                  inputPat.getPassWord()
                                                 );
        try{
            if(PatientDao.getPat(PatientModel) == null){
                PatientDao.insertPat(PatientModel);
            }else{
                System.out.println("Patient Already Exists!");
            }
        }catch (Exception e){
            System.out.println("Exception in inserting Patient: "+e.toString());
        }
        
        System.out.println("PatientService.insertPat end");
    }
}
