package sample.dao;

import java.util.Date;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.FilterOperator;
import sample.meta.MedicalRecordModelMeta;
import sample.model.MedicalRecordModel;

public class MedicalRecordDao {
    
    public MedicalRecordModel getMedicalRecordByName(MedicalRecordModel inputMedicalRecord){
        System.out.println("MedicalRecordDao.getMedicalRecordByName start");
        try{
            MedicalRecordModel record = MedicalRecordModelMeta.get().entityToModel(
                    Datastore.query(MedicalRecordModel.class)
                             .filter("firstName", FilterOperator.EQUAL, inputMedicalRecord.getFirstName())
                             .asSingleEntity()) ;
            
            System.out.println("MedicalRecordDao.getMedicalRecordByName end");
            return record;
        }catch(Exception e){
            System.out.println("MedicalRecordDao.getMedicalRecordByName Exception: "+e.toString());
        }
        return null;
    }
    
    public MedicalRecordModel getMedicalRecordById(MedicalRecordModel inputMedicalRecord){
        System.out.println("MedicalRecordDao.getMedicalRecordById start");
        try{
            MedicalRecordModel record = MedicalRecordModelMeta.get().entityToModel(
                    Datastore.query(MedicalRecordModel.class)
                             .filter("id", FilterOperator.EQUAL, inputMedicalRecord.getId())
                             .asSingleEntity()) ;
        
            System.out.println("MedicalRecordDao.getMedicalRecordById end");
            return record;
        }catch(Exception e){
            System.out.println("MedicalRecordDao.getMedicalRecordById Exception: "+e.toString());
        }
        return null;
    }
    
    public void insertMedicalRecord(MedicalRecordModel inputMedicalRecord){
        System.out.println("MedicalRecordDao.insertMedicalRecord start");
        try{
            Transaction trans = Datastore.beginTransaction();
        
            Key parentKey = KeyFactory.createKey("MedicalRecord", inputMedicalRecord.getFirstName()+inputMedicalRecord.getLastName());
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
    
    public void deleteMedicalRecord(MedicalRecordModel inputMedicalRecord){
        System.out.println("MedicalRecordDao.deleteMedicalRecord start");
        try{
            Transaction trans = Datastore.beginTransaction();
            inputMedicalRecord.setDeletedAt(new Date().toString());
            Datastore.put(inputMedicalRecord);
            trans.commit();
        
            System.out.println("MedicalRecordDao.deleteMedicalRecord end");
        }catch(Exception e){
            System.out.println("MedicalRecordDao.deleteMedicalRecord Exception: "+e.toString());
        }
    }
    
    public void updateMedicalRecord(MedicalRecordModel inputMedicalRecord){
        System.out.println("MedicalRecordDao.updateMedicalRecord start");
        try{
            Transaction trans = Datastore.beginTransaction();
            Datastore.put(trans, inputMedicalRecord);
            trans.commit();
            
            System.out.println("MedicalRecordDao.updateMedicalRecord end");
        }catch(Exception e){
            System.out.println("MedicalRecordDao.updateMedicalRecord Exception: "+e.toString());
        }
    }
}
