package sample.service;

import java.util.ArrayList;
import java.util.Date;

import sample.dao.DiseaseDao;
import sample.dto.DiseaseDto;
import sample.model.DiseaseModel;


public class DiseaseService {
    static DiseaseDao diseaseDao = new DiseaseDao();
    
    public Boolean insertDisease(DiseaseDto inputDisease){
        System.out.println("MedicineService.insertMed start");
        
        DiseaseModel diseaseModel = new DiseaseModel();
        diseaseModel.setName(inputDisease.getName());
        diseaseModel.setMedicineId(inputDisease.getMedicineId());
        diseaseModel.setSymptomId(inputDisease.getSymptomId());
        
        try{
            if(diseaseDao.checkDiseaseExist(diseaseModel.getName())==null){
                System.out.println("www");
                diseaseDao.insertDisease(diseaseModel);
            }else{
                System.out.println("Medicine Already Exists!");
                return false ;
            }
        }catch(Exception e){
            System.out.println("Exception in inserting medicine: "+e.toString());
        }
        
        System.out.println("MedicineService.insertMed end");
        return true ;
    }
    
   
        public static  Boolean updateDisease(DiseaseDto diseaseDto) {
            System.out.println("MedicineService.updateRecord " + "start");
        
            DiseaseModel diseaseModel = storeDtoToModel(diseaseDto);
            
            try {
                // checking if there is already the same item that exists in the datastore.
                DiseaseModel resultModel = (DiseaseModel) diseaseDao.checkDiseaseExist(diseaseModel.getName());
                
                if (resultModel != null) {
                    // setting the key in order to properly update the item
                    diseaseModel.setKey(resultModel.getKey());
                    diseaseModel.setUpdatedAt(new Date());
                    // update the entity to the datastore.
                    diseaseDao.updateDisease(diseaseModel);
                    return true;
                    
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            return false;
           
        }
        public static Boolean deleteDisease(DiseaseDto diseaseDto) {
            System.out.println("DiseaseService.deleteRecord " + "start");
            DiseaseModel diseaseModel = storeDtoToModel(diseaseDto);
            
            try { 
                // checking if there is already the same item that exists in the datastore.
                DiseaseModel resultModel = diseaseDao.checkDiseaseExist(diseaseModel.getName());
                
                if (resultModel != null) {
                    // setting the key in order to properly delete the item
                    diseaseModel.setKey(resultModel.getKey());
                    diseaseModel.setDeletedAt(new Date());
                    // delete the entity to the datastore.
                    diseaseDao.deleteDisease(diseaseModel);
                
                    System.out.println("Deleted Medicine");
                    return true ;
                } else {
                    // deleting was canceled.
                    System.out.println("There is no item with the same id.");
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            System.out.println("MedicineService.deleteRecord " + "end");
            return false;
        }
        private static DiseaseModel storeDtoToModel(DiseaseDto diseaseDto) {
               
            DiseaseModel diseaseModel = new DiseaseModel();
                
                // Storing the data from the DTO.
                diseaseModel.setSymptomId(diseaseDto.getSymptomId());
                diseaseModel.setMedicineId(diseaseDto.getMedicineId());
                diseaseModel.setName(diseaseDto.getName());
          
                System.out.println("DiseaseService.storeDtoToModel " + "end");
                
                // returning the model
                return diseaseModel;
            
        }
        public static ArrayList<DiseaseModel> getAllDisease(){
            return diseaseDao.getAllDisease();
        }
    }


