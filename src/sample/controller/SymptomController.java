package sample.controller;


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

        SymptomDto symptomDto = new SymptomDto();
        JSONObject jsonObject = null;
        JSONValidators validator;

        String method = request.getMethod();
        String message;
       
        try{
            
            if(method.equalsIgnoreCase("POST")){
                jsonObject = new JSONObject(this.request.getReader().readLine());

                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    
                    symptomDto = new SymptomDto(jsonObject);
               
                    symptomDto.setCreatedAt(new Date());
                   
                    
                    message = symptomService.insertSymp(symptomDto);
                    
                    if (message.equals("")) {
                        jsonObject.put("success", true);
                    } else {
                        jsonObject.put("errors", message);
                        response.setStatus(400);
                    }
                
                }

            } else if(method == "GET") {
                jsonObject = new JSONObject(new RequestMap(this.request));
                
                if(jsonObject.has("id")){
                    jsonObject.put("symptom", SymptomService.getSymptom(jsonObject.getLong("id")));
                    
                } else {
                    jsonObject.put("symptoms", SymptomService.getAllSymp());
                }
                
            }
            /*  else if(method == "PUT") {
                
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                
                
                if(validator.validate()){
                    
                   
                    createdAts = jsonObject.getString("createdAt").split(" ");
                    
                 
                    createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                    
                    symptomDto = new SymptomDto(jsonObject);
                    
                    
                    symptomDto.setId(jsonObject.getLong("id"));
                    
                   
                    symptomDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                    symptomDto.setUpdatedAt(new Date());
                    symptomDto.setDeletedAt(null);
                    
                    message = symptomService.updateSymptom(symptomDto);
                    
                    if(message.equals("")){
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
                    
                    symptomDto = new SymptomDto(jsonObject);
                    
                    symptomDto.setId(jsonObject.getLong("id"));
                    
                   
                    symptomDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                    symptomDto.setUpdatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(updatedAt));
                    symptomDto.setDeletedAt(new Date());
                    
                    message = symptomService.deleteSymptom(symptomDto);
                    
                    if(message.equals("")){
                        jsonObject.put("success", true);
                    } else {
                        response.setStatus(400);
                        jsonObject.put("errors", message);
                    }
                }
            } */

        } catch(Exception e){
            System.err.println(e.toString());
            // Adds error message if it exists
            symptomDto.addError("Symptom Controller Error:" + e.getMessage());
            if(jsonObject == null){
                jsonObject = new JSONObject();
            }
            
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