package sample.dao;

import java.util.ArrayList;
import java.util.List;


import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

import sample.meta.MedicineModelMeta;
import sample.model.DiseaseModel;
import sample.model.MedicineModel;


public class MedicineDao {
    
    public Boolean validate(MedicineModel medModel){
        Boolean retVal;
        
        Entity entity = Datastore.query(MedicineModel.class)
            .filter(CompositeFilterOperator.and(
                new FilterPredicate("name", FilterOperator.EQUAL, medModel.getName()),
                new FilterPredicate("deletedAt", FilterOperator.EQUAL, null)),
                new FilterPredicate("id", FilterOperator.NOT_EQUAL, medModel.getId()))
            .asSingleEntity();
        
        if(entity == null){
            retVal = true;
        } else {
            retVal = false;
        }
        
        return retVal;
    }
    
    public MedicineModel getMedById(Long id){
        System.out.println("MedicineDao.getMedById start");
        
        MedicineModel medicine = null;
        
        Entity entity = Datastore.query(MedicineModel.class)
        .filter(CompositeFilterOperator.and(
               new FilterPredicate("id", FilterOperator.EQUAL, id),
               new FilterPredicate("deletedAt", FilterOperator.EQUAL, null)))
        .asSingleEntity();
        
        System.out.println(id);
        
        if(entity != null){
            medicine = MedicineModelMeta.get().entityToModel(entity);
        }
        
        return medicine;
    }
    
    public MedicineModel getMed(String name){
        System.out.println("MedicineDao.getMed start");
        
        MedicineModel medicine = null;
        
        Entity entity = Datastore.query(MedicineModel.class)
        .filter(CompositeFilterOperator.and(
               new FilterPredicate("name", FilterOperator.EQUAL, name.toLowerCase()),
               new FilterPredicate("deletedAt", FilterOperator.EQUAL, null)))
        .asSingleEntity();
        
        if(entity != null){
            medicine = MedicineModelMeta.get().entityToModel(entity);
        }
        
        System.out.println("MedicineDao.getMed end");
        return medicine;
    }
    
    public void insertMed(MedicineModel inputMed){
        System.out.println("MedicineDao.insertMed start");
        Transaction trans = Datastore.beginTransaction();
        
        Key parentKey = KeyFactory.createKey("Medicine", inputMed.getName());
        Key key = Datastore.allocateId(parentKey, "MedicineModel");
        
        inputMed.setKey(key);
        inputMed.setId(key.getId());
        
        Datastore.put(inputMed);
        trans.commit();
        System.out.println("MedicineDao.insertMed end");
    }
    
    
    public Object getMedicines(){
        ArrayList<MedicineModel> results =  new ArrayList<MedicineModel>();

        List<Entity> entities = Datastore.query(MedicineModel.class).filter(
            "deletedAt", FilterOperator.EQUAL, null
            ).asEntityList();

        for(Entity entity : entities) {
            results.add(MedicineModelMeta.get().entityToModel(entity));
        }
               
        return results;
    }
    
    public void updateMedicine(MedicineModel inputMedicine) {
        System.out.println("MedicineDao.updateMedicine " + "start");
        
        Transaction trans = Datastore.beginTransaction();
        
        Datastore.put(trans, inputMedicine);
        
        trans.commit();
        
        System.out.println("MedicineDao.updateMedicine " + "end");
    }
    /**
     * Used to insert the 'Medicine' to the datastore
     * @param inputDoc - the item to be inserted
     */
   
    public void deleteMedicine(MedicineModel inputDoc) {
        System.out.println("MedicineDao.deleteMedicine " + "start");
        Transaction trans = Datastore.beginTransaction();
        Datastore.put(inputDoc);
        trans.commit();
        System.out.println("MedicineDao.deleteMedicine " + "end");
    }
    
    public Boolean checkHold(MedicineModel medModel){
        Boolean retVal;
        
        List<Long> values = new ArrayList<Long>();
        
        values.add(medModel.getId());
        
        Entity entity = Datastore.query(DiseaseModel.class)
            .filter(CompositeFilterOperator.and(
                new FilterPredicate("medicineIdList", FilterOperator.IN, values),
                new FilterPredicate("deletedAt", FilterOperator.EQUAL, null)))
            .asSingleEntity();
        
        if(entity == null){
            retVal = true;
        } else {
            retVal = false;
        }
        
        return retVal;
    }

}
