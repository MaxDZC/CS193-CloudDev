package sample.dao;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.datastore.Query.FilterOperator;

import sample.model.MedicineModel;

public class MedicineDao {
    
    public MedicineModel getMed(MedicineModel inputMed){
        System.out.println("MedicineDao.getMed start");
        
        
        
        if(Datastore.query("MedicineModel")
                .filter("name", FilterOperator.EQUAL, inputMed.getName())
                .asSingleEntity() == null){
            System.out.println("MedicineDao.getMed end(success)");
            return null;
        }else{
            System.out.println("MedicineDao.getMed end(failed)");
            return inputMed;
        }
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
}
