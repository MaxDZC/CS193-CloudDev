package sample.dao;

import java.util.Date;
import java.util.ArrayList;


import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.FilterOperator;
import sample.meta.DoctorModelMeta;
import sample.model.DoctorModel;

public class DoctorDao{
    
    /**
     * Used to get only a single 'Doctor' from the datastore with the same 'name'
     * @param inputDoc - contains the information for verification
     * @return DoctorModel returned by the query
     */
    public DoctorModel getDoctorById(Long id){
        System.out.println("DoctorDao.getDoc start");
        DoctorModel doctor =    DoctorModelMeta.get().entityToModel(
            Datastore.query("DoctorModel")
                     .filter("id", FilterOperator.EQUAL, id)
                     .asSingleEntity()) ;
        if(doctor != null){
 
            System.out.println("DoctorDao.getDoc end(success)");
            return doctor;
        }else{
            System.out.println("DoctorDao.getDoc end(failed)");
            return null;
        }
    }
    
    public boolean getDoctorByEmail(String email){
        System.out.println("DoctorDao.getDoc start");
      
        if(
            Datastore.query("DoctorModel")
            .filter("email", FilterOperator.EQUAL, email)
            .asSingleEntity() != null){
 
            System.out.println("DoctorDao.getDoc end(success)");
            return true;
        }else{
            System.out.println("DoctorDao.getDoc end(failed)");
            return false;
        }
    }
    
    public  Object getDoctors(){
        com.google.appengine.api.datastore.DatastoreService datastore = DatastoreServiceFactory
                .getDatastoreService();
                ArrayList<DoctorModel> results =  new ArrayList<DoctorModel>();

               Query query = new Query("DoctorModel");
                java.util.List<Entity> entities = datastore.prepare(query).asList(
                 FetchOptions.Builder.withDefaults());

               for (Entity entity : entities) {
                 results.add(DoctorModelMeta.get().entityToModel(entity));
               }
               
            return results ;
        
    }
    public void updateDoctor(DoctorModel inputDoctor) {
        System.out.println("DoctorDao.updateDoctor " + "start");
        // TODO: Implement this function.
        Transaction trans = Datastore.beginTransaction();
        
        Datastore.put(trans, inputDoctor);
        
        trans.commit();
        System.out.println("DoctorDao.updateDoctor " + "end");
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
        inputDoc.setCreatedaAt(new Date().toString());
        
        //inserting the item to the datastore
        Datastore.put(inputDoc);
        trans.commit();
        System.out.println("DoctorDao.insertDoc end");
    }


    public void deleteDoctor(DoctorModel inputDoc) {
        // TODO Auto-generated method stub

            System.out.println("DoctorDao.deleteDoctor " + "start");
            // TODO: Implement this function.
            Transaction trans = Datastore.beginTransaction();
            Datastore.put(inputDoc);
            trans.commit();
            System.out.println("DoctorDao.deleteDoctor " + "end");
        
        
    }

}
