package sample.dao;

import java.util.ArrayList;
import java.util.List;

import org.slim3.datastore.Datastore;
import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;

import sample.dto.DoctorDto;
import sample.model.DoctorModel;
import sample.model.MedicalRecordModel;

public class DoctorDao{
    
    public DoctorModel getDoctorById(Long id){
        System.out.println("DoctorDao.getDoc start");
        
        DoctorModel doctor;
        
        doctor = Datastore.query(DoctorModel.class)
                     .filter("id", FilterOperator.EQUAL, id)
                     .filter("deletedAt", FilterOperator.EQUAL, null)
                 .asSingle();
        
        if(doctor != null){
            System.out.println("DoctorDao.getDoc end(success)");
        }else{
            System.out.println("DoctorDao.getDoc end(failed)");
        }
        
        return doctor;
    }
    
    public String validateDoctor(DoctorDto inputs){
        System.out.println("DoctorDao.validate start");
        String msg= "";
        
        if(checkDoctorExistsByEmail(inputs.getEmail())){
            System.out.println("DoctorDao.getDoc end(success)");
            msg += "email";
        }
        
        if(checkDoctorExistsByUsername(inputs.getUsername())){
            System.out.println("DoctorDao.getDoc end(success)");
            if(!msg.equals("")){
                msg += ",";
            }
            msg += "username";
        }
        
        return msg;
    }
    
    public boolean checkDoctorExistsByEmail(String email){
        System.out.println("DoctorDao.getDoc start");
        
        DoctorModel checker;
        boolean ret;
        
        checker = Datastore.query(DoctorModel.class)
                    .filter("email", FilterOperator.EQUAL, email)
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asSingle();
      
        if(checker != null){
            System.out.println("DoctorDao.getDoc end(success)");
            ret = true;
        }else{
            System.out.println("DoctorDao.getDoc end(failed)");
            ret = false;
        }
        
        return ret;
    }
    
    public boolean checkDoctorUpdateEmail(String email, Long id){
        System.out.println("DoctorDao.updateEmailCheck start");
        
        DoctorModel checker;
        boolean ret;
        
        checker = Datastore.query(DoctorModel.class)
                    .filter("id", FilterOperator.NOT_EQUAL, id)
                    .filter("email", FilterOperator.EQUAL, email)
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asSingle();
        
        if(checker != null){
            System.out.println("DoctorDao.updateEmailCheck end (found)");
            ret = true;
        } else {
            System.out.println("DoctorDao.updateEmailCheck end (not found)");
            ret = false;
        }
        
        return ret;
    }
    
    public boolean checkDoctorExistsByUsername(String username){
        System.out.println("DoctorDao.getDoc start");
        
        DoctorModel checker;
        boolean ret;
      
        checker = Datastore.query(DoctorModel.class)
                    .filter("username", FilterOperator.EQUAL, username)
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asSingle();
        
        if(checker != null) {
            System.out.println("DoctorDao.getDoc end(success)");
            ret = true;
        } else {
            System.out.println("DoctorDao.getDoc end(failed)");
            ret = false;
        }
        
        return ret;
    }
    
    
    public DoctorModel getDoctorByEmailandPassword(String user,String password){  
        System.out.println("DoctorDao.getDocByEmailAndPass start");
       
        DoctorModel doctor;

        
        doctor = Datastore.query(DoctorModel.class).filter(
            CompositeFilterOperator.and(
                CompositeFilterOperator.or(
                    new FilterPredicate("username",FilterOperator.EQUAL, user.toLowerCase()), 
                    new FilterPredicate("email", FilterOperator.EQUAL, user.toLowerCase())),
                new FilterPredicate("password", FilterOperator.EQUAL, password),
                new FilterPredicate("deletedAt", FilterOperator.EQUAL, null))
            ).asSingle();
        
        System.out.println("DoctorDao.getDocByEmailAndPass end");
        return doctor;
    }
    
    public List<DoctorModel> getDoctors(){ 
        System.out.println("DoctorDao.getDoctors start");
        
        List<DoctorModel> results =  new ArrayList<DoctorModel>();
        
        results = Datastore.query(DoctorModel.class)
                .filter("admin", FilterOperator.EQUAL, false)
                .filter("deletedAt", FilterOperator.EQUAL, null)
             .asList();
        
        System.out.println("DoctorDao.getDoctors end");
        return results;
    }
    
    public void updateDoctor(DoctorModel inputDoctor) {
        System.out.println("DoctorDao.updateDoctor start");
        
        Transaction trans = Datastore.beginTransaction();
        Datastore.put(trans, inputDoctor);
        trans.commit();
        
        System.out.println("DoctorDao.updateDoctor end");
    }
    
    public void insertDoc(DoctorModel inputDoc){
        System.out.println("DoctorDao.insertDoc start");
        
        Transaction trans = Datastore.beginTransaction();
        
        //creating key and ID for the new entity
        Key parentKey = KeyFactory.createKey("Doctor", inputDoc.getCreatedAt().toString() + inputDoc.getUsername());
        Key key = Datastore.allocateId(parentKey, DoctorModel.class);

        //Setting the 'key' and 'id' of the model
        inputDoc.setKey(key);
        inputDoc.setId(key.getId());
        
        //inserting the item to the datastore
        Datastore.put(inputDoc);
        trans.commit();
        
        System.out.println("DoctorDao.insertDoc end");
    }


    public void deleteDoctor(DoctorModel inputDoc) {
        System.out.println("DoctorDao.deleteDoctor start");
        
        Transaction trans = Datastore.beginTransaction();
        Datastore.put(inputDoc);
        trans.commit();
        
        System.out.println("DoctorDao.deleteDoctor end");
    }
    
    public Boolean checkHold(Long id){
        System.out.println("DoctorDao.checkHold start");
        
        List<MedicalRecordModel> medRecModels;
        
        medRecModels = Datastore.query(MedicalRecordModel.class)
                    .filter("doctorId", FilterOperator.EQUAL, id)
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asList();
        
        return (medRecModels.size() == 0);
    }

}
