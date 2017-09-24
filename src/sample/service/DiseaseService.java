package sample.service;

import java.util.ArrayList;

import sample.dao.DiseaseDao;
import sample.dao.SymptomDao;
import sample.dto.DiseaseDto;
import sample.model.DiseaseModel;


public class DiseaseService {
    static DiseaseDao diseaseDao = new DiseaseDao();
    
    public Boolean insertDisease(DiseaseDto inputDisease){
        System.out.println("MedicineService.insertMed start");
        
        DiseaseModel diseaseModel = new DiseaseModel(inputDisease);
        Boolean state = true;
        
        try{
            if(diseaseDao.checkDiseaseExistByName(diseaseModel.getName()) == null){
                diseaseDao.insertDisease(diseaseModel);
            } else {
                System.out.println("Disease Already Exists!");
                state = false;
            }
        } catch (Exception e){
            System.out.println("Exception in inserting medicine: "+e.toString());
        }
        
        System.out.println("MedicineService.insertMed end");
        return state;
    }
    
   
    public Boolean updateDisease(DiseaseDto diseaseDto) {
        System.out.println("MedicineService.updateRecord " + "start");
    
        DiseaseModel diseaseModel = new DiseaseModel(diseaseDto);
        DiseaseModel resultModel;
        Boolean state = false;
        
        diseaseModel.setId(diseaseDto.getId());
        
        try {
            if(diseaseDao.validate(diseaseModel)) {
            
                resultModel = diseaseDao.checkDiseaseExist(diseaseModel.getId());
                
                if (resultModel != null) {
                    diseaseModel.setKey(resultModel.getKey());
                    diseaseDao.updateDisease(diseaseModel);
                    state = true;
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return state;
       
    }
        
    public Boolean deleteDisease(DiseaseDto diseaseDto) {
        System.out.println("DiseaseService.deleteRecord " + "start");
        
        DiseaseModel diseaseModel = new DiseaseModel(diseaseDto);
        DiseaseModel resultModel;
        Boolean state = false;
        
        diseaseModel.setId(diseaseDto.getId());
        
        try { 
            if(diseaseDao.checkIfUsed(diseaseModel)){
                resultModel = diseaseDao.checkDiseaseExist(diseaseModel.getId());
                
                if (resultModel != null) {
                    diseaseModel.setKey(resultModel.getKey());
                    diseaseDao.deleteDisease(diseaseModel);
                
                    System.out.println("Deleted Disease");
                    state = true;
                } else {
                    System.out.println("There is no item with the same id.");
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        System.out.println("MedicineService.deleteRecord " + "end");
        return state;
    }
        
    public ArrayList<DiseaseModel> getAllDisease(){
        SymptomDao symptomDao = new SymptomDao();
        
        symptomDao.cleanUp();
        
        return diseaseDao.getAllDisease();
    }
    
    public DiseaseModel getDisease(String name){
        return diseaseDao.checkDiseaseExistByName(name);
    }
}


