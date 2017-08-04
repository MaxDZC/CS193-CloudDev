package sample.dao;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Transaction;

import sample.model.DoctorModel;

public class DoctorDao{
    
    /**
     * Used to get only a single 'Doctor' from the datastore with the same 'name'
     * @param inputDoc - contains the information for verification
     * @return DoctorModel returned by the query
     */
    public DoctorModel getDoc(DoctorModel inputDoc){
        System.out.println("DoctorDao.getDoc start");
        
        if(Datastore.query("DoctorModel")
                .filter("firstName", 
                         FilterOperator.EQUAL, 
                         inputDoc.getFirstName()
                        ).asSingleEntity() == null){
            
            System.out.println("DoctorDao.getDoc end(success)");
            return null;
        }else{
            System.out.println("DoctorDao.getDoc end(failed)");
            return inputDoc;
        }
    }
    
    /**
     * Used to insert the 'Doctor' to the datastore
     * @param inputDoc - the item to be inserted
     */
    public void insertDoc(DoctorModel inputDoc){
        System.out.println("DoctorDao.insertDoc start");
        Transaction trans = Datastore.beginTransaction();
        
        //creating key and ID for the new entity
        Key parentKey = KeyFactory.createKey("Doctor", inputDoc.getFirstName()+inputDoc.getLastName());
        Key key = Datastore.allocateId(parentKey, "DoctorModel");
        
        //Setting the 'key' and 'id' of the model
        inputDoc.setKey(key);
        inputDoc.setId(key.getId());
        
        //inserting the item to the datastore
        Datastore.put(inputDoc);
        trans.commit();
        System.out.println("DoctorDao.insertDoc end");
    }
}
