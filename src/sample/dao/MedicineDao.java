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

import sample.model.DiseaseModel;
import sample.model.MedicineModel;


public class MedicineDao {
    
    public Boolean validate(MedicineModel medModel){
        System.out.println("MedicineDao.validate start");
        
        MedicineModel medicineModel;
        
        medicineModel = Datastore.query(MedicineModel.class)
                .filter("id", FilterOperator.NOT_EQUAL, medModel.getId())
                .filter("name", FilterOperator.EQUAL, medModel.getName())
                .filter("deletedAt", FilterOperator.EQUAL, null)
            .asSingle();
        
        System.out.println("MedicineDao.validate end");
        return (medicineModel == null);
    }
    
    public MedicineModel getMedById(Long id){
        System.out.println("MedicineDao.getMedById start");
        
        MedicineModel medicine;
        
        medicine = Datastore.query(MedicineModel.class)
                    .filter("id", FilterOperator.EQUAL, id)
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asSingle();
        
        return medicine;
    }
    
    public MedicineModel getMed(String name){
        System.out.println("MedicineDao.getMed start");
        
        MedicineModel medicine;
        
        medicine = Datastore.query(MedicineModel.class)
                    .filter("name", FilterOperator.EQUAL, name)
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asSingle();
        
        System.out.println("MedicineDao.getMed end");
        return medicine;
    }
    
    public void insertMed(MedicineModel inputMed){
        System.out.println("MedicineDao.insertMed start");
        Transaction trans = Datastore.beginTransaction();
        
        Key parentKey = KeyFactory.createKey("Medicine", inputMed.getCreatedAt().toString() + inputMed.getName());
        Key key = Datastore.allocateId(parentKey, "MedicineModel");
        
        inputMed.setKey(key);
        inputMed.setId(key.getId());
        
        Datastore.put(inputMed);
        trans.commit();
        System.out.println("MedicineDao.insertMed end");
    }
    
    
    public List<MedicineModel> getMedicines(){
        System.out.println("MedicineDao.getMedicines start");
        
        List<MedicineModel> medicines;
        
        medicines = Datastore.query(MedicineModel.class)
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asList();
         
        System.out.println("MedicineDao.getMedicines end");
        return medicines;
    }
    
    public void updateMedicine(MedicineModel inputMedicine) {
        System.out.println("MedicineDao.updateMedicine start");
        
        Transaction trans = Datastore.beginTransaction();
        Datastore.put(trans, inputMedicine);
        trans.commit();
        
        System.out.println("MedicineDao.updateMedicine end");
    }
   
    public void deleteMedicine(MedicineModel inputDoc) {
        System.out.println("MedicineDao.deleteMedicine " + "start");
        
        Transaction trans = Datastore.beginTransaction();
        Datastore.put(inputDoc);
        trans.commit();
        
        System.out.println("MedicineDao.deleteMedicine " + "end");
    }
    
    public Boolean checkHold(MedicineModel medModel){
        List<Long> values = new ArrayList<Long>();
        
        values.add(medModel.getId());
        
        Entity entity = Datastore.query(DiseaseModel.class)
            .filter(CompositeFilterOperator.and(
                new FilterPredicate("medicineIdList", FilterOperator.IN, values),
                new FilterPredicate("deletedAt", FilterOperator.EQUAL, null)))
            .asSingleEntity();
        
        return (entity == null);
    }

}
