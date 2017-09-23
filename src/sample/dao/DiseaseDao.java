package sample.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.datastore.Query.FilterOperator;

import sample.meta.DiseaseModelMeta;
import sample.model.DiseaseModel;
import sample.model.MedicalRecordModel;

public class DiseaseDao extends DaoBase<DiseaseModel>{
    
    public DiseaseModel checkDiseaseExistByName(String name) {
        
        Entity entity = Datastore.query(DiseaseModel.class)
                .filter("name", FilterOperator.EQUAL, name)
                .filter("deletedAt", FilterOperator.EQUAL, null)
            .asSingleEntity();
        
        DiseaseModel disease = null;
        
        if(entity != null){
            disease = DiseaseModelMeta.get().entityToModel(entity);
        }
        
        return disease;
    }
    
    public DiseaseModel checkDiseaseExist(Long id) {
        
        Entity entity = Datastore.query("DiseaseModel")
                .filter("id", FilterOperator.EQUAL, id)
                .filter("deletedAt", FilterOperator.EQUAL, null)
            .asSingleEntity();
        
        DiseaseModel disease = null;
        
        if(entity != null){
            disease = DiseaseModelMeta.get().entityToModel(entity);
        }
        
        return disease;
    }
    
    public Boolean validate(DiseaseModel diseaseModel){
        
        DiseaseModel check;
        
        check = Datastore.query(DiseaseModel.class)
                .filter("name", FilterOperator.EQUAL, diseaseModel.getName())
                .filter("deletedAt", FilterOperator.EQUAL, null)
                .filter("id", FilterOperator.NOT_EQUAL, diseaseModel.getId())
            .asSingle();
        
        return (check == null);
        
    }
    
    public Boolean checkIfUsed(DiseaseModel diseaseModel){
        
        MedicalRecordModel medRecord;
        List<Long> diseaseId = new ArrayList<Long>();
        
        diseaseId.add(diseaseModel.getId());
        
        medRecord = Datastore.query(MedicalRecordModel.class)
                    .filter("diseaseIdList", FilterOperator.IN, diseaseId)
                    .filter("dischargeDate", FilterOperator.GREATER_THAN, new Date())
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asSingle();
        
        return (medRecord == null);
    }
    
    public ArrayList<DiseaseModel> getAllDisease(){
        
        ArrayList<DiseaseModel> results =  new ArrayList<DiseaseModel>();
        
        List<Entity> entities = Datastore.query(DiseaseModel.class)
                .filter("deletedAt", FilterOperator.EQUAL, null)
            .asEntityList();

        for (Entity entity : entities) {
            results.add(DiseaseModelMeta.get().entityToModel(entity));
        }
        
        return results;
    }
    
    public void insertDisease(DiseaseModel model){
        System.out.println("DiseaseDao.insertDisease start");
        
        Transaction trans = Datastore.beginTransaction();
        
        //creating key and ID for the new entity
        Key parentKey = KeyFactory.createKey("Disease", model.getId() + model.getName());
        Key key = Datastore.allocateId(parentKey, DiseaseModel.class);
        
        model.setKey(key);
        model.setId(key.getId());
        Datastore.put(model);
        
        trans.commit();
        
        System.out.println("Disease.insertDoc end");
    }
    
    public void updateDisease(DiseaseModel diseaseModel) {
        System.out.println("DiseaseDao.updateDisease " + "start");
        
        Transaction trans = Datastore.beginTransaction();
 
        Datastore.put(trans, diseaseModel);
        
        trans.commit();
        System.out.println("DiseaseDao.updateDisease" + "end");
    }
    
    public void deleteDisease(DiseaseModel inputDis) {
        System.out.println("DoctorDao.deleteDisease " + "start");
      
        Transaction trans = Datastore.beginTransaction();
        
        Datastore.put(inputDis);
        
        trans.commit();
        System.out.println("DoctorDao.deleteDisease " + "end");
    }
}