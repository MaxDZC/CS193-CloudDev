package sample.service;

import sample.dao.SymptomDao;
import sample.dto.SymptomDto;
import sample.model.SymptomModel;



public class SymptomService {
    /**
     * Used to access the DAO functions for the SymptomModel
     */
    static SymptomDao symptomDao = new SymptomDao();
    
    public Boolean insertSymp(SymptomDto inputSymp){
        System.out.println("SymptomService.insertSymp start");
        
        SymptomModel symptomModel;
        Boolean status = true;
        
        symptomModel = new SymptomModel(inputSymp);
        
        try {
            if(symptomDao.checkSymptomExistsByName(symptomModel.getName())){
                System.out.println("SymptomService.insertSymp insert");
                symptomDao.insertSymp(symptomModel);
            } else {
                System.out.println("Symptom Already Exists!");
                status = false;
            }
        }catch (Exception e){
            System.out.println("Exception in inserting symptor: "+e.toString());
        }
        
        System.out.println("SymptomService.insertSymp end");
        
        return status;
    }
    
    public Boolean updateSymptom(SymptomDto symptomDto) {
        System.out.println("MedicineService.updateRecord " + "start");
    
        SymptomModel symptomModel = new SymptomModel(symptomDto);
        SymptomModel resultModel;
        Boolean state = false;
        
        symptomModel.setId(symptomDto.getId());
        
        try {
            if(symptomDao.checkIfNameIsUsed(symptomModel)){
                resultModel = symptomDao.getSymp(symptomModel.getId());
                
                if (resultModel != null) {
                    symptomModel.setKey(resultModel.getKey());
                    symptomDao.updateSymptom(symptomModel);
                    state = true;
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return state;
    }
    
    public Boolean deleteSymptom(SymptomDto symptomDto){
        System.out.println("SymptomService.deleteRecord start");
        
        SymptomModel symptomModel = new SymptomModel(symptomDto);
        SymptomModel resultModel;
        Boolean state = false;
        
        symptomModel.setId(symptomDto.getId());
        
        try { 
            if(symptomDao.checkIfUsed(symptomModel)){
                resultModel = symptomDao.getSymp(symptomModel.getId());
                
                if (resultModel != null) {
                    symptomModel.setKey(resultModel.getKey());
                    symptomDao.deleteSymptom(symptomModel);
                    System.out.println("Deleted Symptom");
                    state = true;
                } else {
                    System.out.println("There is no item with the same id.");
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        System.out.println("SymptomService.deleteSymptom end");
        return state;
    }
    
    public static Object getAllSymp(){
        return symptomDao.getAllSymp();
    }
    
    public static Object getSymptom(Long id) {
        return symptomDao.getSymp(id);
    }
}
