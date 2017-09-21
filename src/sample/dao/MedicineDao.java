package sample.dao;

import java.util.ArrayList;


import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.datastore.Query.FilterOperator;

import sample.meta.MedicineModelMeta;
import sample.model.MedicineModel;


public class MedicineDao {
    
    public MedicineModel getMed(Long id){
        System.out.println("MedicineDao.getMed start");
        
        MedicineModel medicine = MedicineModelMeta.get().entityToModel(Datastore.query(MedicineModel.class)
                .filter("id", FilterOperator.EQUAL, id)
                .asSingleEntity() );
        
 
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
    
    
    public  Object getMedicines(){
        com.google.appengine.api.datastore.DatastoreService datastore = DatastoreServiceFactory
                .getDatastoreService();
                ArrayList<MedicineModel> results =  new ArrayList<MedicineModel>();

               Query query = new Query("MedicineModel");
                java.util.List<Entity> entities = datastore.prepare(query).asList(
                 FetchOptions.Builder.withDefaults());

               for (Entity entity : entities) {
                 results.add(MedicineModelMeta.get().entityToModel(entity));
               }
               
            return results ;
        
    }
    public void updateMedicine(MedicineModel inputMedicine) {
        System.out.println("MedicineDao.updateMedicine " + "start");
        // TODO: Implement this function.
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
        // TODO Auto-generated method stub

            System.out.println("MedicineDao.deleteMedicine " + "start");
            // TODO: Implement this function.
            Transaction trans = Datastore.beginTransaction();
            Datastore.put(inputDoc);
            trans.commit();
            System.out.println("MedicineDao.deleteMedicine " + "end");
        
        
    }

}
