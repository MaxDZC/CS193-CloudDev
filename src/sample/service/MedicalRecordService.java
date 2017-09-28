package sample.service;

import java.util.List;

import sample.dao.MedicalRecordDao;
import sample.dto.MedicalRecordDto;
import sample.model.MedicalRecordModel;


public class MedicalRecordService {
    
    static MedicalRecordDao medicalRecordDao = new MedicalRecordDao();
    
    public void insertMedicalRecord(MedicalRecordDto inputMedicalRecord){
        System.out.println("MedicalRecordService.insertMedicalRecord start");
        
        MedicalRecordModel medicalRecordModel;
        
        try{
            medicalRecordModel = new MedicalRecordModel(inputMedicalRecord);
            
            if(medicalRecordDao.getMedicalRecordByPatientInfo(medicalRecordModel) == null) {
                System.out.println("MedicalRecordService.insertMedicalRecord Success");
                medicalRecordDao.insertMedicalRecord(medicalRecordModel);
            } else {
                System.out.println("MedicalRecordService.insertMedicalRecord Failed: Duplicate detected");
            }
            
            System.out.println("MedicalRecordService.insertMedicalRecord end");
        }catch(Exception e){
            System.out.println("MedicalRecordService.insertMedicalRecord Exception: "+e.toString());
        }
    }
    
    public void deleteOrUpdateMedicalRecord(MedicalRecordDto inputMedicalRecord){
        System.out.println("MedicalRecordService.deleteOrUpdateMedicalRecord start");
        
        MedicalRecordModel medicalRecordModel, getModel;
        
        try{
            medicalRecordModel = new MedicalRecordModel(inputMedicalRecord);
            getModel = medicalRecordDao.getMedicalRecordById(medicalRecordModel);
            
            if(getModel != null) {
                medicalRecordModel.setKey(getModel.getKey());
                medicalRecordDao.deleteOrUpdateMedicalRecord(medicalRecordModel);
                System.out.println("MedicalRecordService.deleteOrUpdateMedicalRecord Success");
            } else {
                System.out.println("MedicalRecordService.deleteOrMedicalRecord Failed: No matching record");
            }
            
            System.out.println("MedicalRecordService.deleteOrMedicalRecord end");
        } catch(Exception e) {
            System.out.println("MedicalRecordService.deleteOrMedicalRecord Exception: "+e.toString());
        }
    }
    
    public List<MedicalRecordModel> getMedicalRecords() {
        return medicalRecordDao.getMedicalRecords();
    }
    
 
    public List<MedicalRecordModel> getMedicalRecordByDoctorId(Long id) {
        return medicalRecordDao.getMedicalRecordByDoctorId(id);
    }
}
