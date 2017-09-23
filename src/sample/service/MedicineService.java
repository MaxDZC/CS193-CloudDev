package sample.service;

import sample.dao.MedicineDao;
import sample.dto.MedicineDto;
import sample.model.MedicineModel;


public class MedicineService {
    static MedicineDao medicineDao = new MedicineDao();
    
    public Boolean insertMed(MedicineDto inputMed){
        System.out.println("MedicineService.insertMed start");
        
        MedicineModel medicineModel = new MedicineModel(inputMed);
        Boolean retVal = true;
        
        try{
            if(medicineDao.getMed(medicineModel.getName()) == null){
                System.out.println("Inserting medicine...");
                medicineDao.insertMed(medicineModel);
            }else{
                System.out.println("Medicine Already Exists!");
                retVal = false;
            }
        }catch(Exception e){
            System.out.println("Exception in inserting medicine: "+e.toString());
        }
        
        System.out.println("MedicineService.insertMed end");
        return retVal;
    }
    
   
    public Boolean updateMedicine(MedicineDto medicineDto) {
        System.out.println("MedicineService.updateMedicine start");
    
        MedicineModel medicineModel = new MedicineModel(medicineDto);
        MedicineModel resultModel;
        Boolean ret = false;
        
        medicineModel.setId(medicineDto.getId());
        
        try {
            if(medicineDao.validate(medicineModel) && medicineDao.checkHold(medicineModel)){
                resultModel = medicineDao.getMedById(medicineModel.getId());
                
                if (resultModel != null) {
                    medicineModel.setKey(resultModel.getKey());
                    medicineDao.updateMedicine(medicineModel);
                    ret = true;        
                }
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        System.out.println("MedicineService.updateMedicine end");
        return ret;
    }
    
    
    public Boolean deleteMedicine(MedicineDto medicineDto) {
        System.out.println("MedicineService.deleteRecord start");
        
        MedicineModel medicineModel = new MedicineModel(medicineDto);
        MedicineModel resultModel = null;
        Boolean retVal = false;
        
        medicineModel.setId(medicineDto.getId());
    
        try {
            if(medicineDao.checkHold(medicineModel)){
                resultModel = medicineDao.getMedById(medicineDto.getId());
            
                if (resultModel != null) {
                    medicineModel.setKey(resultModel.getKey());
                    medicineDao.deleteMedicine(medicineModel);   
                    System.out.println("Deleted Medicine");
                    retVal = true ;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
        System.out.println("MedicineService.deleteRecord end");
        return retVal;
    }
    
    public static Object getMedicines() {
        return medicineDao.getMedicines();
    }
    
    public static Object getMedicineById(Long id) {
        return medicineDao.getMedById(id);
    }
}


