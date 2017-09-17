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
import sample.model.SymptomModel;

public class SymptomDao{
    
    /**
     * Used to get only a single 'Symptom' from the datastore with the same 'name'
     * @param inputSymp - contains the information for verification
     * @return SymptomModel returned by the query
     */
    public SymptomModel getSymp(SymptomModel inputSymp){
        System.out.println("SymptomDao.getSymp start");
        
        if(Datastore.query("SymptomModel")
                .filter("name", 
                         FilterOperator.EQUAL, 
                         inputSymp.getName()
                        ).asSingleEntity() == null){
            
            System.out.println("SymptomDao.getSymp end(success)");
            return null;
        }else{
            System.out.println("SymptomDao.getSymp end(failed)");
            return inputSymp;
        }
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
        
        //inserting the item to the datastore
        Datastore.put(inputSymp);
        trans.commit();
        System.out.println("SymptomDao.insertSymp end");
    }
}
