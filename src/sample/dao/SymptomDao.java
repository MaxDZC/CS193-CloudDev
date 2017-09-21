package sample.dao;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Transaction;

import sample.meta.SymptomModelMeta;
import sample.model.DoctorModel;
import sample.model.SymptomModel;

public class SymptomDao{
    
    /**
     * Used to get only a single 'Symptom' from the datastore with the same 'name'
     * @param id - contains the information for verification
     * @return SymptomModel returned by the query
     */
    public SymptomModel getSymp(Long id){
        System.out.println("SymptomDao.getSymp start");
        
        SymptomModel symptom = SymptomModelMeta.get().entityToModel(
            Datastore.query("SymptomModel")
                     .filter("id", FilterOperator.EQUAL, id)
                    
                     .asSingleEntity()) ;
        if(symptom != null){
            System.out.println("SymptomDao.getSymp end(success)");
        }else{
            System.out.println("SymptomDao.getSymp end(failed)");
        }
        
        return symptom;
    }
    public ArrayList<SymptomModel> getAllSymp(){
        ArrayList<SymptomModel> symp = new ArrayList<SymptomModel>();
        List<Entity> getSymp = Datastore.query("SymptomModel").asList();
        for(int i =0;i<getSymp.size();i++){
            symp.add(SymptomModelMeta.get().entityToModel(getSymp.get(i)));
        }
        return symp;
    }
    
    /**
     * Used to insert the 'Symptom' to the datastore
     * @param inputSymp - the item to be inserted
     */
    
    public void insertSymp(SymptomModel inputSymp){
        System.out.println("SymptomDao.insertSymp start");
        Transaction trans = Datastore.beginTransaction();
        
        //creating key and ID for the new entity
        Key parentKey = KeyFactory.createKey("Symptom", inputSymp.getName());
        Key key = Datastore.allocateId(parentKey, "SymptomModel");
        
        //Setting the 'key' and 'id' of the model
        inputSymp.setKey(key);
        inputSymp.setId(key.getId());
        inputSymp.setName(inputSymp.getName().toLowerCase());
        //inserting the item to the datastore
        Datastore.put(inputSymp);
        trans.commit();
        System.out.println("SymptomDao.insertSymp end");
    }
    
    public boolean checkSymptomExistsByName(String name){
        System.out.println("SymptomDao.checkSymptom start");
        
        boolean ret;
      
        if(
            Datastore.query(SymptomModel.class)
            .filter("name", FilterOperator.EQUAL, name.toLowerCase())
            .asSingleEntity() != null){
 
            System.out.println("SymptomDao.checkSymptom end(success)");
            ret = true;
        }else{
            System.out.println("SymptomDao.checkSymptom end(failed)");
            ret = false;
        }
        
        return ret;
    }
}
