package sample.service;

import java.util.Date;

import sample.dao.PatientDao;
import sample.dto.PatientDto;
import sample.model.PatientModel;


public class PatientService {
    /**
     * Used to access the DAO functions for the PatientModel
     */
    static PatientDao patientDao = new PatientDao();
    
    
    /**
     * Used to insert an item to the datastore
     * @param inputPat - the dto that contains the data to be stored in the model object
     */
    public Boolean insertPatient(PatientDto inputPatient){
        System.out.println("PatientService.insertPat start");
        
        PatientModel patientModel = new PatientModel(inputPatient);
        
        try{
            if(PatientDao.getPat(patientModel) == null){
                PatientDao.insertPat(patientModel);
            }else{
                System.out.println("Patient Already Exists!");
                return false;
            }
        }catch (Exception e){
            System.out.println("Exception in inserting Patient: "+e.toString());
        }
        
        System.out.println("PatientService.insertPat end");
        return true;
    }
    public Boolean updatePatient(PatientDto patientDto) {
        System.out.println("PatientService.updateRecord " + "start");
    
        PatientModel patientModel = new PatientModel(patientDto);
        
        try {
            // checking if there is already the same item that exists in the datastore.
            PatientModel resultModel = (PatientModel) patientDao.getPatientById(patientModel.getId());
            
            if (resultModel != null) {
                // setting the key in order to properly update the item
                patientModel.setKey(resultModel.getKey());
                patientModel.setUpdatedAt(new Date().toString());
                // update the entity to the datastore.
                PatientService.patientDao.updatePatient(patientModel);
                return true;
                
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return false;
       
    }
    public Boolean deletePatient(PatientDto patientDto) {
        System.out.println("PatientService.deleteRecord " + "start");
        /**
         * PatientModel that will be stored to the datastore. 
         */
        PatientModel patientModel = new PatientModel(patientDto);
        
        try { 
            // checking if there is already the same item that exists in the datastore.
            PatientModel resultModel = (PatientModel) patientDao.getPatientById(patientDto.getId());
            
            if (resultModel != null) {
                // setting the key in order to properly delete the item
                patientModel.setKey(resultModel.getKey());
                patientModel.setDeletedAt(new Date().toString());
                // delete the entity to the datastore.
                PatientService.patientDao.deletePatient(patientModel);
            
                System.out.println("Deleted Patient");
                return true ;
            } else {
                // deleting was canceled.
                System.out.println("There is no item with the same id.");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.println("PatientService.deleteRecord " + "end");
        return false;
    }
    
    public static Object getPatients() {
        // TODO Auto-generated method stub
        return patientDao.getPatients();
    }
    public static Object getPatient(Long id) {
        // TODO Auto-generated method stub
        return patientDao.getPatientById(id);
    }
}
