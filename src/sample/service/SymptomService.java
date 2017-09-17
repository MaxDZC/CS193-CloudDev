package sample.service;

import java.util.ArrayList;

import sample.dao.SymptomDao;
import sample.dto.SymptomDto;
import sample.model.SymptomModel;


public class SymptomService {
    /**
     * Used to access the DAO functions for the SymptomModel
     */
    SymptomDao SymptomDao = new SymptomDao();
    
    /**
     * Used to insert an item to the datastore
     * @param inputSymp - the dto that contains the data to be stored in the model object
     */
    public Boolean insertSymp(SymptomDto inputSymp){
        System.out.println("SymptomService.insertSymp start");
        
        SymptomModel SymptomModel = new SymptomModel();
        SymptomModel.setName(inputSymp.getName());
        try{
            if(SymptomDao.getSymp(SymptomModel) == null){
                SymptomDao.insertSymp(SymptomModel);
            }else{
                System.out.println("Symptom Already Exists!");
                return false;
            }
        }catch (Exception e){
            System.out.println("Exception in inserting Symptom: "+e.toString());
        }
        
        System.out.println("SymptomService.insertSymp end");
        return true;
    }
    public ArrayList<SymptomModel> getAllSymp(){
        return SymptomDao.getAllSymp();
    }
}
