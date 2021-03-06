package sample.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import sample.dto.MedicineDto;
import sample.meta.MedicineModelMeta;
import sample.service.MedicalRecordService;
import sample.service.MedicineService;
import sample.utils.JSONValidators;

public class MedicineController extends Controller {

    /**
    * Service object that will be used to call CRUD functions to datastore
    */
    MedicineService medicineService = new MedicineService();
    MedicalRecordService medicalRecordService = new MedicalRecordService();

    @Override
    protected Navigation run() throws Exception {
        System.out.println("MedicineController.run start");

        MedicineDto medicineDto = new MedicineDto();
        JSONObject jsonObject = new JSONObject();
        JSONValidators validator;
        
        String createdAt;
        String updatedAt;
        String[] createdAts;
        String[] updatedAts;
        Date createdAtNew;
        Date updatedAtNew;
        Object aObj;

        String method = request.getMethod();
        boolean message;
        
        try{
            
            if(method.equals("POST")){
                jsonObject = new JSONObject(this.request.getReader().readLine());

                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    medicineDto = new MedicineDto(jsonObject);
                    medicineDto.setCreatedAt(new Date());
                    
                    message = medicineService.insertMed(medicineDto);
                    
                    if (message) {
                        jsonObject.put("success", message);
                    } else {
                        jsonObject.put("errors", message);
                        response.setStatus(400);
                    }
                }

            } else if(method.equals("GET")) {
                jsonObject = new JSONObject(new RequestMap(this.request));
                
                if(jsonObject.has("id")){
                    jsonObject.put("medicine", MedicineModelMeta.get().modelToJson(MedicineService.getMedicineById(jsonObject.getLong("medicineId"))));
                } else {
                    jsonObject.put("medicines", MedicineService.getMedicines());
                    jsonObject.put("medicalRecords", medicalRecordService.getMedicalRecords());
                }
            } else if(method.equals("PUT")) {
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    
                    medicineDto = new MedicineDto(jsonObject);
                    
                    aObj = jsonObject.get("createdAt");
                    
                    if(aObj instanceof String){
                        createdAts = jsonObject.getString("createdAt").split(" ");
                        
                        createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                        
                        medicineDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                    } else {
                        createdAtNew = new Date(jsonObject.getLong("createdAt"));
                        
                        medicineDto.setCreatedAt(createdAtNew);
                    }
                    
                    medicineDto.setId(jsonObject.getLong("id"));
                    medicineDto.setUpdatedAt(new Date());
                    
                    message = medicineService.updateMedicine(medicineDto);
                    
                    if(message){
                        jsonObject.put("success", message);
                    } else {
                        jsonObject.put("errors", message);
                        response.setStatus(400);
                    }
                }
                    
            } else if(method.equals("DELETE")) {
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){     
                    
                    medicineDto = new MedicineDto(jsonObject);
                    
                    aObj = jsonObject.get("createdAt");
                    
                    if(aObj instanceof String){
                        createdAts = jsonObject.getString("createdAt").split(" ");
                        createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                        medicineDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                        
                        if(jsonObject.has("updatedAt")){
                            updatedAts = jsonObject.getString("updatedAt").split(" ");
                            updatedAt = updatedAts[5] + "-" + updatedAts[1] + "-" + updatedAts[2];
                            medicineDto.setUpdatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(updatedAt));
                        }
                        
                    } else {
                        createdAtNew = new Date(jsonObject.getLong("createdAt"));            
                        medicineDto.setCreatedAt(createdAtNew);
                        
                        if(jsonObject.has("updatedAt")){ 
                            updatedAtNew = new Date(jsonObject.getLong("updated At")); 
                            medicineDto.setUpdatedAt(updatedAtNew);
                        }
                    }
                    
                    medicineDto.setId(jsonObject.getLong("id"));
                    medicineDto.setDeletedAt(new Date());
                    
                    message = medicineService.deleteMedicine(medicineDto);
                    
                    if(message){
                        jsonObject.put("success", message);
                    } else {
                        response.setStatus(400);
                        jsonObject.put("errors", message);
                    }
                }
            }

        } catch(Exception e){
            System.err.println(e.toString());
            // Adds error message if it exists
            medicineDto.addError("Medicine Controller Error:" + e.getMessage());
            
        }
        
        jsonObject.put("errorList", medicineDto.getErrorList());
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonObject.toString());

        System.out.println("MedicineController.run end");
        // screen redirection.
        return null;
    }
}