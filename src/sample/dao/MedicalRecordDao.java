package sample.dao;

import java.util.Date;
import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.FilterOperator;

import sample.model.MedicalRecordModel;

public class MedicalRecordDao {
    
    public MedicalRecordModel getMedicalRecordByPatientInfo(MedicalRecordModel inputMedicalRecord){
        System.out.println("MedicalRecordDao.getMedicalRecordByPatientInfo start");
        MedicalRecordModel record = null;
        
        try{
            record = Datastore.query(MedicalRecordModel.class)
                        .filter("patientId", FilterOperator.EQUAL, inputMedicalRecord.getPatientId())
                        .filter("dischargeDate", FilterOperator.GREATER_THAN, new Date())
                        .filter("deletedAt", FilterOperator.EQUAL, null)
                    .asSingle();
            
            System.out.println("MedicalRecordDao.getMedicalRecordByPatientInfo end");
        } catch(Exception e) {
            System.out.println("MedicalRecordDao.getMedicalRecordByPatientInfo Exception: "+e.toString());
        }
        
        return record;
    }
    
    public MedicalRecordModel getMedicalRecordById(MedicalRecordModel inputMedicalRecord){
        System.out.println("MedicalRecordDao.getMedicalRecordById start");
        
        MedicalRecordModel record = null;
        
        try {
            record = Datastore.query(MedicalRecordModel.class)
                        .filter("id", FilterOperator.EQUAL, inputMedicalRecord.getId())
                        .filter("deletedAt", FilterOperator.EQUAL, null)
                    .asSingle();
        
            System.out.println("MedicalRecordDao.getMedicalRecordById end");
        } catch(Exception e) {
            System.out.println("MedicalRecordDao.getMedicalRecordById Exception: "+e.toString());
        }
        
        return record;
    }
    
    public void insertMedicalRecord(MedicalRecordModel inputMedicalRecord){
        System.out.println("MedicalRecordDao.insertMedicalRecord start");
        
        try{
            Transaction trans = Datastore.beginTransaction();
        
            Key parentKey = KeyFactory.createKey("MedicalRecord", inputMedicalRecord.getDoctorId()+inputMedicalRecord.getPatientId()+new Date().toString());
            Key key = Datastore.allocateId(parentKey, MedicalRecordModel.class);
        
            inputMedicalRecord.setKey(key);
            inputMedicalRecord.setId(key.getId());
        
            Datastore.put(inputMedicalRecord);
        
            trans.commit();
            System.out.println("MedicalRecordDao.insertMedicalRecord end");
        } catch(Exception e) {
            System.out.println("MedicalRecordDao.insertMedicalRecord Exception: "+e.toString());
        }
    }
    
    public void deleteOrUpdateMedicalRecord(MedicalRecordModel inputMedicalRecord){
        System.out.println("MedicalRecordDao.deleteOrUpdateMedicalRecord start");
        
        try{
            Transaction trans = Datastore.beginTransaction();
            Datastore.put(inputMedicalRecord);
            trans.commit();
        
            System.out.println("MedicalRecordDao.deleteOrUpdateMedicalRecord end");
        }catch(Exception e){
            System.out.println("MedicalRecordDao.deleteOrUpdateMedicalRecord Exception: "+e.toString());
        }
    }
    
    public static String processDate(String date){
        String[] dates;
        
        dates = date.split(" ");
        
        date = dates[5] + "-" + dates[1] + "-" + dates[2];
        
        return date;
    }

    public List<MedicalRecordModel> getMedicalRecords() {
        
        List<MedicalRecordModel> medRecModels;
        
        medRecModels = Datastore.query(MedicalRecordModel.class)
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asList();
        
        return medRecModels;
    }

  

    public List<MedicalRecordModel> getMedicalRecordByDoctorId(Long id) {
        
        List<MedicalRecordModel> medRecModels;
        
        medRecModels = Datastore.query(MedicalRecordModel.class)
                    .filter("doctorId", FilterOperator.EQUAL, id)
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asList();
        
        return medRecModels;
    }
}
