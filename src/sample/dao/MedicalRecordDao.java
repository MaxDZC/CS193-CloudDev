package sample.dao;

import java.util.Date;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

import sample.meta.MedicalRecordModelMeta;
import sample.model.MedicalRecordModel;

public class MedicalRecordDao {
    
    public MedicalRecordModel getMedicalRecordByPatientInfo(MedicalRecordModel inputMedicalRecord){
        System.out.println("MedicalRecordDao.getMedicalRecordByPatientInfo start");
        MedicalRecordModel record = null;
        try{
            record = MedicalRecordModelMeta.get().entityToModel(
                    Datastore.query(MedicalRecordModel.class)
                             .filter(CompositeFilterOperator.and(
                                 new FilterPredicate("patientId", FilterOperator.EQUAL, inputMedicalRecord.getPatientId()),
                                 new FilterPredicate("dischargeDate", FilterOperator.LESS_THAN, new Date()),
                                 new FilterPredicate("deletedAt", FilterOperator.EQUAL, null)))
                             .asSingleEntity()) ;
            
            System.out.println("MedicalRecordDao.getMedicalRecordByPatientInfo end");
        }catch(Exception e){
            System.out.println("MedicalRecordDao.getMedicalRecordByPatientInfo Exception: "+e.toString());
        }
        
        return record;
    }
    
    public MedicalRecordModel getMedicalRecordById(MedicalRecordModel inputMedicalRecord){
        System.out.println("MedicalRecordDao.getMedicalRecordById start");
        MedicalRecordModel record = null;
        try{
            record = MedicalRecordModelMeta.get().entityToModel(
                    Datastore.query(MedicalRecordModel.class)
                             .filter("id", FilterOperator.EQUAL, inputMedicalRecord.getId())
                             .asSingleEntity()) ;
        
            System.out.println("MedicalRecordDao.getMedicalRecordById end");
        }catch(Exception e){
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
        }catch(Exception e){
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
}
