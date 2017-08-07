package sample.dao;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Transaction;

import sample.model.PatientModel;

public class PatientDao{
    
    /**
     * Used to get only a single 'Patient' from the datastore with the same 'name'
     * @param inputPat - contains the information for verification
     * @return PatientModel returned by the query
     */
    public PatientModel getPat(PatientModel inputPat){
        System.out.println("PatientDao.getPat start");
        
        if(Datastore.query("PatientModel")
                .filter("firstName", 
                         FilterOperator.EQUAL, 
                         inputPat.getFirstName()
                        ).asSingleEntity() == null){
            
            System.out.println("PatientDao.getPat end(success)");
            return null;
        }else{
            System.out.println("PatientDao.getPat end(failed)");
            return inputPat;
        }
    }
    
    /**
     * Used to insert the 'Patient' to the datastore
     * @param inputPat - the item to be inserted
     */
    public void insertPat(PatientModel inputPat){
        System.out.println("PatientDao.insertPat start");
        Transaction trans = Datastore.beginTransaction();
        
        //creating key and ID for the new entity
        Key parentKey = KeyFactory.createKey("Patient", inputPat.getFirstName()+inputPat.getLastName());
        Key key = Datastore.allocateId(parentKey, "PatientModel");
        
        //Setting the 'key' and 'id' of the model
        inputPat.setKey(key);
        inputPat.setId(key.getId());
        
        //inserting the item to the datastore
        Datastore.put(inputPat);
        trans.commit();
        System.out.println("PatientDao.insertPat end");
    }
}
