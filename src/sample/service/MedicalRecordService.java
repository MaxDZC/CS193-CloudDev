package sample.service;

import sample.dao.MedicalRecordDao;
import sample.dto.MedicalRecordDto;
import sample.model.MedicalRecordModel;


public class MedicalRecordService {
    
    static MedicalRecordDao medicalRecordDao = new MedicalRecordDao();
    
    public void insertMedicalRecord(MedicalRecordDto inputMedicalRecord){
        System.out.println("MedicalRecordService.insertMedicalRecord start");
        try{
            MedicalRecordModel medicalRecordModel = new MedicalRecordModel(inputMedicalRecord);
            
            if(medicalRecordDao.getMedicalRecordByPatientInfo(medicalRecordModel) == null){
                medicalRecordDao.insertMedicalRecord(medicalRecordModel);
                System.out.println("MedicalRecordService.insertMedicalRecord Success");
            }else{
                System.out.println("MedicalRecordService.insertMedicalRecord Failed: Duplicate detected");
            }
            
            System.out.println("MedicalRecordService.insertMedicalRecord end");
        }catch(Exception e){
            System.out.println("MedicalRecordService.insertMedicalRecord Exception: "+e.toString());
        }
    }
    
    public void deleteOrUpdateMedicalRecord(MedicalRecordDto inputMedicalRecord){
        System.out.println("MedicalRecordService.deleteOrUpdateMedicalRecord start");
        
        try{
            MedicalRecordModel medicalRecordModel = new MedicalRecordModel(inputMedicalRecord);
            
            if(medicalRecordDao.getMedicalRecordById(medicalRecordModel) != null){
                medicalRecordDao.deleteOrUpdateMedicalRecord(medicalRecordModel);
                System.out.println("MedicalRecordService.deleteOrUpdateMedicalRecord Success");
            }else{
                System.out.println("MedicalRecordService.deleteOrMedicalRecord Failed: No matching record");
            }
            System.out.println("MedicalRecordService.deleteOrMedicalRecord end");
        }catch(Exception e){
            System.out.println("MedicalRecordService.deleteOrMedicalRecord Exception: "+e.toString());
        }
    }
}
