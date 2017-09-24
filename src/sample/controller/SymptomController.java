package sample.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import sample.dto.SymptomDto;
import sample.service.SymptomService;
import sample.utils.JSONValidators;

public class SymptomController extends Controller {

    /**
    * Service object that will be used to call CRUD functions to datastore
    */
    SymptomService symptomService = new SymptomService();

    @Override
    protected Navigation run() throws Exception {
        System.out.println("SymptomController.run start");

        JSONValidators validator;
        Boolean message;
        Object checkObj;
        String[] createdAts;
        String[] updatedAts;
        String createdAt;
        String updatedAt;
        Date createdAtNew;
        Date updatedAtNew;

        SymptomDto symptomDto = new SymptomDto();
        JSONObject jsonObject = new JSONObject();
        String method = request.getMethod();
       
        try{
            if(method.equals("POST")){
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    symptomDto = new SymptomDto(jsonObject);
                    symptomDto.setCreatedAt(new Date());
                    message = symptomService.insertSymp(symptomDto);
                    
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
                    jsonObject.put("symptom", SymptomService.getSymptom(jsonObject.getLong("id")));
                } else {
                    jsonObject.put("symptoms", SymptomService.getAllSymp());
                }
                
            } else if(method.equals("PUT")) {
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    symptomDto = new SymptomDto(jsonObject);
                    checkObj = jsonObject.get("createdAt");
                    
                    if(checkObj instanceof String){
                        createdAts = jsonObject.getString("createdAt").split(" ");
                        createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                        symptomDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                    } else {
                        createdAtNew = new Date(jsonObject.getLong("createdAt"));
                        symptomDto.setCreatedAt(createdAtNew);
                    }
                    
                    symptomDto.setId(jsonObject.getLong("id"));
                    symptomDto.setUpdatedAt(new Date());
                    
                    message = symptomService.updateSymptom(symptomDto);
                    
                    if(message) {
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
             
                    symptomDto = new SymptomDto(jsonObject);
                    checkObj = jsonObject.get("createdAt");
                    
                    if(checkObj instanceof String){
                        createdAts = jsonObject.getString("createdAt").split(" ");
                        createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                        symptomDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                        
                        if(jsonObject.has("updatedAt")){
                            updatedAts = jsonObject.getString("updatedAt").split(" ");
                            updatedAt = updatedAts[5] + "-" + updatedAts[1] + "-" + updatedAts[2];
                            symptomDto.setUpdatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(updatedAt));
                        }
                        
                    } else {
                        createdAtNew = new Date(jsonObject.getLong("createdAt"));            
                        symptomDto.setCreatedAt(createdAtNew);
                        
                        if(jsonObject.has("updatedAt")){ 
                            updatedAtNew = new Date(jsonObject.getLong("updated At")); 
                            symptomDto.setUpdatedAt(updatedAtNew);
                        }
                    }

                    symptomDto.setId(jsonObject.getLong("id"));
                    symptomDto.setDeletedAt(new Date());
                    
                    message = symptomService.deleteSymptom(symptomDto);
                    
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
            symptomDto.addError("Symptom Controller Error:" + e.getMessage());
            
        }
        
        jsonObject.put("errorList", symptomDto.getErrorList());
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonObject.toString());

        System.out.println("SymptomController.run end");
        // screen redirection.
        return null;
    }
}