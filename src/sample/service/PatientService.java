package sample.service;

import sample.dao.PatientDao;
import sample.dto.PatientDto;
import sample.model.PatientModel;


public class PatientService {
    /**
     * Used to access the DAO functions for the PatientModel
     */
    static PatientDao patientDao = new PatientDao();

    public Boolean insertPatient(PatientDto inputPatient){
        System.out.println("PatientService.insertPat start");
        
        PatientModel patientModel = new PatientModel(inputPatient);
        Boolean state = true;
        
        try{
            if(patientDao.getPat(patientModel) == null) {
                System.out.println("Inserting Patient");
                PatientDao.insertPat(patientModel);
            } else {
                System.out.println("Patient Already Exists!");
                state = false;
            }
        }catch (Exception e) {
            System.out.println("Exception in inserting Patient: "+e.toString());
        }
        
        System.out.println("PatientService.insertPat end");
        return state;
    }
    
    public Boolean updatePatient(PatientDto patientDto) {
        System.out.println("PatientService.updatePatient start");
    
        PatientModel resultModel;
        PatientModel patientModel = new PatientModel(patientDto);
        Boolean state = false;
        
        patientModel.setId(patientDto.getId());
        
        try {
            if(patientDao.getPat(patientModel) == null){ 
                resultModel = (PatientModel) patientDao.getPatientById(patientModel.getId());
                
                if (resultModel != null) {
                    patientModel.setKey(resultModel.getKey());
                    patientDao.updatePatient(patientModel);
                    state = true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return state;
    }
    
    public Boolean deletePatient(PatientDto patientDto) {
        System.out.println("PatientService.deleteRecord " + "start");

        PatientModel patientModel = new PatientModel(patientDto);
        Boolean state = false;
        
        patientModel.setId(patientDto.getId());
        
        try { 
            if(patientDao.checkHold(patientModel)){ 
                PatientModel resultModel = (PatientModel) patientDao.getPatientById(patientDto.getId());
                
                if (resultModel != null) {
                    patientModel.setKey(resultModel.getKey());
                    patientDao.deletePatient(patientModel);
                    System.out.println("Deleted Patient");
                    state = true;
                } else {
                    System.out.println("There is no item with the same id. Did not delete");
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        System.out.println("PatientService.deleteRecord end");
        return state;
    }
    
    public static Object getPatients() {
        return patientDao.getPatients();
    }
    
    public static Object getPatient(Long id) {
        return patientDao.getPatientById(id);
    }
}
