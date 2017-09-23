package sample.dao;

import java.util.List;

import org.slim3.datastore.Datastore;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Transaction;

import sample.model.MedicalRecordModel;
import sample.model.PatientModel;


public class PatientDao{

    public PatientModel getPat(PatientModel inputPat){
        System.out.println("PatientDao.getPat start");
        
        PatientModel patientModel;
        
        patientModel = Datastore.query(PatientModel.class)
                    .filter("firstname", FilterOperator.EQUAL, inputPat.getFirstname())
                    .filter("lastname", FilterOperator.EQUAL, inputPat.getLastname())
                    .filter("contactNo", FilterOperator.EQUAL, inputPat.getContactNo())
                    .filter("birthday", FilterOperator.EQUAL, inputPat.getBirthday())
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asSingle();
        
        if(patientModel == null){
            System.out.println("PatientDao.getPat end(success)");
        } else {
            System.out.println("PatientDao.getPat end(failed)");
        }
        
        return patientModel;
    }

    public PatientModel getPatientById(Long id){
        System.out.println("PatientDao.getPat start");
        
        PatientModel patient;
        
        patient = Datastore.query(PatientModel.class)
                    .filter("id", FilterOperator.EQUAL, id)
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asSingle();
        
        if(patient != null) {
            System.out.println("PatientDao.getPat end(success)");
        } else {
            System.out.println("PatientDao.getPat end(failed)");
        }
        
        return patient;
    }
    
    public List<PatientModel> getPatients(){
        List<PatientModel> allPatients;

        allPatients = Datastore.query(PatientModel.class)
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asList();
        
        return allPatients;
    }
    
    public void updatePatient(PatientModel inputPatient) {
        System.out.println("PatientDao.updatePatient start");
        
        Transaction trans = Datastore.beginTransaction();
        Datastore.put(trans, inputPatient);
        trans.commit();
        
        System.out.println("PatientDao.updatePatient " + "end");
    }
    
    public static void insertPat(PatientModel inputPat) {
        System.out.println("PatientDao.insertPat start");
        
        Transaction trans = Datastore.beginTransaction();
        
        //creating key and ID for the new entity
        Key parentKey = KeyFactory.createKey("Patient", inputPat.getFirstname()+inputPat.getLastname()+inputPat.getContactNo()+inputPat.getBirthday().toString());
        Key key = Datastore.allocateId(parentKey, "PatientModel");
        
        //Setting the 'key' and 'id' of the model
        inputPat.setKey(key);
        inputPat.setId(key.getId());
        Datastore.put(inputPat);
        trans.commit();
        
        System.out.println("PatientDao.insertPat end");
    }
    
    public void deletePatient(PatientModel inputPat) {
        System.out.println("PatientDao.deletePatient start");
        
        Transaction trans = Datastore.beginTransaction();
        Datastore.put(inputPat);
        trans.commit();
        
        System.out.println("PatientDao.deletePatient end");       
    }
    
    public Boolean checkHold(PatientModel patientModel){
        System.out.println("PatientDao.checkHold start");
        
        MedicalRecordModel medicalRecordModel;
        
        medicalRecordModel = Datastore.query(MedicalRecordModel.class)
                    .filter("patientId", FilterOperator.EQUAL, patientModel.getId())
                    .filter("deletedAt", FilterOperator.EQUAL, null)
                .asSingle();
        
        return (medicalRecordModel == null);
    }
}
