package sample.dao;

import java.util.ArrayList;

import org.slim3.datastore.DaoBase;
import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Transaction;
import com.google.appengine.api.datastore.Query.FilterOperator;

import sample.meta.DiseaseModelMeta;
import sample.model.DiseaseModel;

public class DiseaseDao extends DaoBase<DiseaseModel>{
    
    public DiseaseModel checkDiseaseExist(String name){
        
        System.out.println(name);
        
        Entity entity = Datastore.query("DiseaseModel")
                .filter("name", FilterOperator.EQUAL, name)
                .asSingleEntity();
        DiseaseModel disease = null;
        
        if(entity != null){
            disease = DiseaseModelMeta.get().entityToModel(entity);
        }
        
        return disease;
    }
    
    public ArrayList<DiseaseModel>  getAllDisease(){
        com.google.appengine.api.datastore.DatastoreService datastore = DatastoreServiceFactory
                .getDatastoreService();
        ArrayList<DiseaseModel> results =  new ArrayList<DiseaseModel>();

        Query query = new Query("DiseaseModel");
        java.util.List<Entity> entities = datastore.prepare(query).asList(
         FetchOptions.Builder.withDefaults());

        for (Entity entity : entities) {
            results.add(DiseaseModelMeta.get().entityToModel(entity));
        }
        return results;
    }
    
    public boolean insertDisease(DiseaseModel model){
        System.out.println("hereaa");
        Transaction trans = Datastore.beginTransaction();
        
        //creating key and ID for the new entity
        Key parentKey = KeyFactory.createKey("Disease", model.getName());
        Key key = Datastore.allocateId(parentKey, DiseaseModel.class);
        
        //Setting the 'key' and 'id' of the model
        model.setKey(key);
        model.setId(key.getId());
        model.setName(processName(model.getName()));
        //inserting the item to the datastore
        Datastore.put(model);
        trans.commit();
        System.out.println("Disease.insertDoc end");
        return true;
    }
    public void updateDisease(DiseaseModel diseaseModel) {
        System.out.println("DiseaseDao.updateDisease " + "start");
        // TODO: Implement this function.
        Transaction trans = Datastore.beginTransaction();
        
        Datastore.put(trans, diseaseModel);
        
        trans.commit();
        System.out.println("DiseaseDao.updateDisease" + "end");
    }
    public static String processName(String name){
        String retName;
        String[] names;
        int i;
        
        names = name.split(" ");
        retName = "";
        
        for(i = 0; i < names.length; i++){
            names[i] = Character.toUpperCase(names[i].charAt(0)) + names[i].substring(1).toLowerCase();
            retName += names[i];
            if(i + 1 != names.length){
                retName += " ";
            }
        }
        
        return retName;     
    }
    public void deleteDisease(DiseaseModel inputDis) {
        // TODO Auto-generated method stub

            System.out.println("DoctorDao.deleteDoctor " + "start");
            // TODO: Implement this function.
            Transaction trans = Datastore.beginTransaction();
            Datastore.put(inputDis);
            trans.commit();
            System.out.println("DoctorDao.deleteDoctor " + "end");
        
        
    }
}
