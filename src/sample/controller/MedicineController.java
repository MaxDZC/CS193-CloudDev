package sample.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import sample.dto.MedicineDto;
import sample.meta.MedicineModelMeta;
import sample.service.MedicineService;
import sample.utils.JSONValidators;

public class MedicineController extends Controller {

    /**
    * Service object that will be used to call CRUD functions to datastore
    */
    MedicineService medicineService = new MedicineService();

    @Override
    protected Navigation run() throws Exception {
        System.out.println("MedicineController.run start");

        MedicineDto medicineDto = new MedicineDto();
        JSONObject jsonObject = null;
        JSONValidators validator;
        
        String createdAt;
        String updatedAt;
        String[] createdAts;
        String[] updatedAts;

        String method = request.getMethod();
        boolean message;
        
        try{
            
            if(method.equalsIgnoreCase("POST")){
                jsonObject = new JSONObject(this.request.getReader().readLine());

                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    
                    medicineDto = new MedicineDto(jsonObject);
                    
                    medicineDto.setCreatedAt(new Date());
                    medicineDto.setUpdatedAt(null);
                    medicineDto.setDeletedAt(null);
                    
                    message = medicineService.insertMed(medicineDto);
                    
                    if (message) {
                        jsonObject.put("success", true);
                    } else {
                        jsonObject.put("errors", message);
                        response.setStatus(400);
                    }
                
                }

            } else if(method == "GET") {
                jsonObject = new JSONObject(new RequestMap(this.request));
                
                if(jsonObject.has("id")){
                    jsonObject.put("medicine", MedicineModelMeta.get().modelToJson(MedicineService.getMedicine(jsonObject.getLong("medicineId"))));
                } else {
                    jsonObject.put("medicines", MedicineService.getMedicines());
                }
            } else if(method == "PUT") {
                
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                
                
                if(validator.validate()){
                    
                    createdAts = jsonObject.getString("createdAt").split(" ");
                    
                    createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                    
                    medicineDto = new MedicineDto(jsonObject);
                    
                    
                    medicineDto.setId(jsonObject.getLong("id"));
                    
                    medicineDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                    medicineDto.setUpdatedAt(new Date());
                    medicineDto.setDeletedAt(null);
                    
                    message = medicineService.updateMedicine(medicineDto);
                    
                    if(message){
                        jsonObject.put("success", true);
                    } else {
                        jsonObject.put("errors", message);
                        response.setStatus(400);
                    }
                }
                    
            } else if(method == "DELETE"){
                    
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){                       
                    createdAts = jsonObject.getString("createdAt").split(" ");
                    updatedAts = jsonObject.getString("updatedAt").split(" ");
                    
                    createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                    updatedAt = updatedAts[5] + "-" + updatedAts[1] + "-" + updatedAts[2];
                    
                    medicineDto = new MedicineDto(jsonObject);
                    
                    medicineDto.setId(jsonObject.getLong("medicineId"));
                    
                    medicineDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                    medicineDto.setUpdatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(updatedAt));
                    medicineDto.setDeletedAt(new Date());
                    
                    message = medicineService.deleteMedicine(medicineDto);
                    
                    if(message){
                        jsonObject.put("success", true);
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
            if(jsonObject == null){
                jsonObject = new JSONObject();
            }
            
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