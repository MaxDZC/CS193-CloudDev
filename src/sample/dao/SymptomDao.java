package sample.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Transaction;

import sample.model.DiseaseModel;
import sample.model.SymptomModel;

public class SymptomDao{
    
    public SymptomModel getSymp(Long id){
        System.out.println("SymptomDao.getSymp start");
        
        SymptomModel symptom;
        
        symptom = Datastore.query(SymptomModel.class)
                    .filter("id", FilterOperator.EQUAL, id)
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asSingle();
        
        if(symptom != null){
            System.out.println("SymptomDao.getSymp end(success)");
        }else{
            System.out.println("SymptomDao.getSymp end(failed)");
        }
        
        return symptom;
    }
    
    public List<SymptomModel> getAllSymp(){
        List<SymptomModel> symptoms = new ArrayList<SymptomModel>();
        
        symptoms = Datastore.query(SymptomModel.class)
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asList();
        
        return symptoms;
    }

    public void insertSymp(SymptomModel inputSymp){
        System.out.println("SymptomDao.insertSymp start");
        
        Transaction trans = Datastore.beginTransaction();
        
        Key parentKey = KeyFactory.createKey("Symptom", inputSymp.getId() + inputSymp.getName());
        Key key = Datastore.allocateId(parentKey, "SymptomModel");
        
        inputSymp.setKey(key);
        inputSymp.setId(key.getId());
        Datastore.put(inputSymp);
        trans.commit();
        
        System.out.println("SymptomDao.insertSymp end");
    }
    
    public void updateSymptom(SymptomModel symptomModel) {
        System.out.println("SymptomDao.updateSymptom " + "start");
        
        Transaction trans = Datastore.beginTransaction();
 
        Datastore.put(trans, symptomModel);
        
        trans.commit();
        System.out.println("SymptomDao.updateSymptom" + "end");
    }
    
    public void deleteSymptom(SymptomModel symptomModel){
        System.out.println("SymptomDao.deleteSymptom start");
        
        Transaction trans = Datastore.beginTransaction();
        
        Datastore.put(symptomModel);
        
        trans.commit();
        System.out.println("SymptomDao.deleteSymptom end");
    }
    
    public Boolean checkSymptomExistsByName(String name){
        System.out.println("SymptomDao.checkSymptom start");
        
        Boolean ret;
        SymptomModel symptomModel;
        
        symptomModel = Datastore.query(SymptomModel.class)
             .filter("name", FilterOperator.EQUAL, name)
             .filter("deletedAt", FilterOperator.EQUAL, null)
             .asSingle();
        
        if(symptomModel == null){
            System.out.println("SymptomDao.checkSymptom end (success)");
            ret = true;
        }else{
            System.out.println("SymptomDao.checkSymptom end (failed)");
            ret = false;
        }
        
        return ret;
    }
    
    public Boolean checkIfNameIsUsed(SymptomModel symptomModel){
        
        SymptomModel checker;
        
        checker = Datastore.query(SymptomModel.class)
                    .filter("name", FilterOperator.EQUAL, symptomModel.getName())
                    .filter("id", FilterOperator.NOT_EQUAL, symptomModel.getId())
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asSingle();
        
        return (checker == null);
    }
    
    public Boolean checkIfUsed(SymptomModel symptomModel){
        
        DiseaseModel checker;
        List<Long> symptomIdList = new ArrayList<Long>();
        
        symptomIdList.add(symptomModel.getId());
        
        checker = Datastore.query(DiseaseModel.class)
                    .filter("symptomId", FilterOperator.IN, symptomIdList)
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asSingle();
        
        return (checker == null);
    }
    
    public void cleanUp(){
        System.out.println("SymptomDao.cleanUp start");
        
        List<SymptomModel> symptoms = this.getAllSymp();
        List<Long> checkIds;
        List<DiseaseModel> diseaseModels;
        Transaction tx;
        
        for(SymptomModel symptom : symptoms){
            checkIds = new ArrayList<Long>();
            
            checkIds.add(symptom.getId());
            
            diseaseModels = Datastore.query(DiseaseModel.class)
                        .filter("symptomId", FilterOperator.IN, checkIds)
                        .filter("deletedAt", FilterOperator.EQUAL, null)
                    .asList();
            
            if(diseaseModels.size() == 0){
                symptom.setDeletedAt(new Date());
                
                tx = Datastore.beginTransaction();
                Datastore.put(symptom);
                tx.commit();
                
                System.out.println("Cleaned" + symptom.getName());
            }
        }
        
        System.out.println("SymptomDao.cleanUp end");
    }
    
}
