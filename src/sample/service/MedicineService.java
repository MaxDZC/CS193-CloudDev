package sample.service;

import java.util.Date;

import sample.dao.MedicineDao;
import sample.dto.MedicineDto;
import sample.meta.MedicineModelMeta;
import sample.model.MedicineModel;


public class MedicineService {
    static MedicineDao medicineDao = new MedicineDao();
    
    public Boolean insertMed(MedicineDto inputMed){
        System.out.println("MedicineService.insertMed start");
        
        MedicineModel medicineModel = new MedicineModel(inputMed.getName(),
                                                        inputMed.getDescription(),
                                                        inputMed.getPrice()
                                                       );
        medicineModel.setCreatedaAt(inputMed.getCreatedaAt());
        
        
        try{
            if(medicineDao.getMed(medicineModel.getName()) == null){
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
    
   
        public static  Boolean updateMedicine(MedicineDto medicineDto) {
            System.out.println("MedicineService.updateRecord " + "start");
        
            MedicineModel medicineModel = storeDtoToModel(medicineDto);
            
            try {
                // checking if there is already the same item that exists in the datastore.
                MedicineModel resultModel = MedicineModelMeta.get().entityToModel( medicineDao.getMed(medicineModel.getName()));
                
                if (resultModel != null) {
                    // setting the key in order to properly update the item
                    medicineModel.setKey(resultModel.getKey());
                    medicineModel.setUpdatedAt(new Date().toString());
                    // update the entity to the datastore.
                    MedicineService.medicineDao.updateMedicine(medicineModel);
                    return true;
                    
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            return false;
           
        }
        public static Boolean deleteMedicine(MedicineDto medicineDto) {
            System.out.println("MedicineService.deleteRecord " + "start");
            /**
             * MedicineModel that will be stored to the datastore. 
             */
            MedicineModel medicineModel = storeDtoToModel(medicineDto);
            
            try { 
                // checking if there is already the same item that exists in the datastore.
                MedicineModel resultModel = MedicineModelMeta.get().entityToModel( medicineDao.getMed(medicineDto.getName()));
                
                if (resultModel != null) {
                    // setting the key in order to properly delete the item
                    medicineModel.setKey(resultModel.getKey());
                    medicineModel.setDeletedAt(new Date().toString());
                    // delete the entity to the datastore.
                    MedicineService.medicineDao.deleteMedicine(medicineModel);
                
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
        private static MedicineModel storeDtoToModel(MedicineDto medicineDto) {
               
            MedicineModel medicineModel = new MedicineModel();
                
                // Storing the data from the DTO.
                medicineModel.setId(medicineDto.getId());
                medicineModel.setPrice(medicineDto.getPrice());
                medicineModel.setDescription(medicineDto.getDescription());
                medicineModel.setName(medicineDto.getName());
                     
          
                System.out.println("MedicineService.storeDtoToModel " + "end");
                
                // returning the model
                return medicineModel;
            
        }
        public static Object getMedicines() {
            // TODO Auto-generated method stub
            return medicineDao.getMedicines();
        }
        public static Object getMedicine(String name) {
            // TODO Auto-generated method stub
            return medicineDao.getMed(name);
        }
    }


