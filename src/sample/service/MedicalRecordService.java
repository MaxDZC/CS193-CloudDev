package sample.service;

import java.util.ArrayList;//for testing purposes only

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

import sample.dao.MedicalRecordDao;
import sample.dto.MedicalRecordDto;
import sample.model.MedicalRecordModel;


public class MedicalRecordService {
    
    static MedicalRecordDao medicalRecordDao = new MedicalRecordDao();
    
    public void insertMedicalRecord(MedicalRecordDto inputMedicalRecord){
        System.out.println("MedicalRecordService.insertMedicalRecord start");
        try{
            MedicalRecordModel medicalRecordModel = new MedicalRecordModel(
                inputMedicalRecord.getFirstName(),
                inputMedicalRecord.getLastName(),
                inputMedicalRecord.getBirthDay(),
                inputMedicalRecord.getSex(),
                inputMedicalRecord.getAdmissionDate(),
                inputMedicalRecord.getDisease(),
                inputMedicalRecord.getSymptoms(),
                inputMedicalRecord.getMedicines()
            );
            
            if(medicalRecordDao.getMedicalRecordByName(medicalRecordModel) == null){
                medicalRecordDao.insertMedicalRecord(medicalRecordModel);
                System.out.println("MedicalRecordService.insertMedicalRecord Success");
            }else{
                System.out.println("MedicalRecordService.insertMedicalRecord Failed: Duplicate detected");
            }
            
            System.out.println("MedicalRecordService.insertMedicalRecord end");
        }catch(Exception e){
            System.out.println("MedicalRecordService.insertMedicalRecord Exception: "+e.toString());
        }
    }
    
    public void deleteMedicalRecord(/*medicalRecordDto inputMedicalRecord - get id from that record which was sent*/){
        System.out.println("MedicalRecordService.deleteMedicalRecord start");
        
        try{
          //dummy variable for testing, Should be replaced with DTO when ready
            ArrayList <Integer> tempMedicines = new ArrayList <Integer>();
            
            tempMedicines.add(0);
            
            ArrayList <Integer> tempSymptoms = new ArrayList <Integer>();
            
            tempSymptoms.add(0);
            tempSymptoms.add(1);
            
            MedicalRecordModel medicalRecordModel = new MedicalRecordModel(
                "yanal",
                "horani",
                "1997-05-06T16:00:00.000Z",
                "Male",
                "2017-09-17T16:00:00.000Z",
                "cancer",
                tempSymptoms,
                tempMedicines
            );
            
            Key key = KeyFactory.stringToKey("ahFoZWFsdGhwbHVzLTE3NDQwNXI3CxINTWVkaWNhbFJlY29yZCILeWFuYWxob3JhbmkMCxISTWVkaWNhbFJlY29yZE1vZGVsGOcEDA");
            medicalRecordModel.setId((long)615);
            medicalRecordModel.setKey(key);
            
            if(medicalRecordDao.getMedicalRecordById(medicalRecordModel) != null){
                medicalRecordDao.deleteMedicalRecord(medicalRecordModel);
                System.out.println("MedicalRecordService.deleteMedicalRecord Success");
            }else{
                System.out.println("MedicalRecordService.deleteMedicalRecord Failed: No matching record");
            }
            System.out.println("MedicalRecordService.deleteMedicalRecord end");
        }catch(Exception e){
            System.out.println("MedicalRecordService.deleteMedicalRecord Exception: "+e.toString());
        }
    }
    
    public void updateMedicalRecord(/*MedicalRecordDto inputMedicalRecord - still for getting id of record that was updated*/){
        System.out.println("MedicalRecordService.updateMedicalRecord start");
        try{
            //Dummy variable for testing update, this should be replaced with DTO once ready
            ArrayList <Integer> tempMedicines = new ArrayList <Integer>();
            
            tempMedicines.add(4);
            tempMedicines.add(1);
            
            ArrayList <Integer> tempSymptoms = new ArrayList <Integer>();
            
            tempSymptoms.add(0);
            
            MedicalRecordModel medicalRecordModel = new MedicalRecordModel(
                "max",
                "zuorba",
                "1994-05-05T16:00:00.000Z",
                "Male",
                "2017-09-16T16:00:00.000Z",
                "CTE",
                tempSymptoms,
                tempMedicines
            );
            Key key = KeyFactory.stringToKey("ahFoZWFsdGhwbHVzLTE3NDQwNXI1CxINTWVkaWNhbFJlY29yZCIJbWF4enVvcmJhDAsSEk1lZGljYWxSZWNvcmRNb2RlbBjoBAw");
            medicalRecordModel.setId((long)616);
            medicalRecordModel.setKey(key);
            
            if(medicalRecordDao.getMedicalRecordById(medicalRecordModel) != null){
                medicalRecordDao.updateMedicalRecord(medicalRecordModel);
                System.out.println("MedicalRecordService.updateMedicalRecord Success");
            }else{
                System.out.println("MedicalRecordService.updateMedicalRecord Failed: Corresponding Profile is Missing");
            }
            System.out.println("MedicalRecordService.updateMedicalRecord end");
        }catch(Exception e){
            System.out.println("MedicalRecordService.updateMedicalRecord Exception: "+e.toString());
        }
    }
}
