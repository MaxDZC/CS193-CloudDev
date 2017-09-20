package sample.service;
import sample.dao.SymptomDao;
import sample.dto.SymptomDto;
import sample.model.SymptomModel;



public class SymptomService {
    /**
     * Used to access the DAO functions for the SymptomModel
     */
    static SymptomDao symptomDao = new SymptomDao();
    
    /**
     * Used to insert an item to the datastore
     * @param inputSymp - the dto that contains the data to be stored in the model object
     */
    
    public String insertSymp(SymptomDto inputSymp){
        System.out.println("SymptomService.insertSymp start");
        
        String status = "";
        SymptomModel symptorModel;
        
        symptorModel = new SymptomModel(inputSymp);
        
        
        try { 
            if(status.equals("")){
                symptomDao.insertSymp(symptorModel);
                    
            } else {
                System.out.println("Symptom Already Exists!");
            }
        }catch (Exception e){
            System.out.println("Exception in inserting symptor: "+e.toString());
        }
        
        System.out.println("SymptomService.insertSymp end");
        
        return status;
    }
    public static Object getAllSymp(){
        return symptomDao.getAllSymp();
    }
    public static Object getSymptom(Long id) {
        // TODO Auto-generated method stub
        return symptomDao.getSymp(id);
    }
}
