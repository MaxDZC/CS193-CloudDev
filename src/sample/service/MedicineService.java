package sample.service;

import sample.dao.MedicineDao;
import sample.dto.MedicineDto;
import sample.model.MedicineModel;


public class MedicineService {
    MedicineDao medicineDao = new MedicineDao();
    
    public Boolean insertMed(MedicineDto inputMed){
        System.out.println("MedicineService.insertMed start");
        
        MedicineModel medicineModel = new MedicineModel(inputMed.getName(),
                                                        inputMed.getDescription(),
                                                        inputMed.getPrice()
                                                       );
        
        try{
            if(medicineDao.getMed(medicineModel) == null){
                medicineDao.insertMed(medicineModel);
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
}
