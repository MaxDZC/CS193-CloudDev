package sample.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import sample.dto.PatientDto;
import sample.meta.PatientModelMeta;
import sample.service.PatientService;
import sample.utils.JSONValidators;

public class PatientController extends Controller {
    /**
    * Service object that will be used to call CRUD functions to datastore
    */
    PatientService patientService = new PatientService();

    @Override
    protected Navigation run() throws Exception {
        System.out.println("PatientController.run start");

        PatientDto patientDto = new PatientDto();
        JSONObject jsonObject = null;
        JSONValidators validator;
        
        String birthday;
        String createdAt;
        String updatedAt;
        String[] birthdays;
        String[] createdAts;
        String[] updatedAts;

        String method = request.getMethod();
        boolean message;
        
        try{

            if(method.equalsIgnoreCase("POST")){
                jsonObject = new JSONObject(this.request.getReader().readLine());

                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    
                    patientDto = new PatientDto(jsonObject);
                    
                    birthday = jsonObject.getString("birthday").split("T")[0];
                    
                    patientDto.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
                    patientDto.setCreatedAt(new Date());
                    patientDto.setUpdatedAt(null);
                    patientDto.setDeletedAt(null);
                    
                    message = patientService.insertPatient(patientDto);
                    
                    if (message) {
                        jsonObject.put("success", true);
                    } else {
                        jsonObject.put("errors", message);
                        response.setStatus(400);
                    }
                
                }

            } else if(method == "GET") {
                jsonObject = new JSONObject(new RequestMap(this.request));
                
                if(jsonObject.has("diseaseId")){
                    jsonObject.put("patient", PatientModelMeta.get().modelToJson(PatientService.getPatient(jsonObject.getLong("diseaseId"))));
                } else {
                    jsonObject.put("patients", PatientService.getPatients());
                }
                
            } else if(method == "PUT") {
                
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    
                    Object aObj = jsonObject.get("birthday");
                    patientDto = new PatientDto(jsonObject);
                    
                    if(aObj instanceof String){
                        birthdays = jsonObject.getString("birthday").split(" ");
                        createdAts = jsonObject.getString("createdAt").split(" ");
                    
                        birthday = birthdays[5] + "-" + birthdays[1] + "-" + birthdays[2];
                        createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                        
                        patientDto.setBirthday(new SimpleDateFormat("yyyy-MMM-dd").parse(birthday));
                        patientDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                    } else {
                        Date birthdayNew = new Date(jsonObject.getLong("birthday"));
                        Date createdAtNew = new Date(jsonObject.getLong("createdAt"));
                        
                        patientDto.setBirthday(birthdayNew);
                        patientDto.setCreatedAt(createdAtNew);
                    }
                    
                    patientDto.setId(jsonObject.getLong("id"));
                    
                    patientDto.setUpdatedAt(new Date());
                    patientDto.setDeletedAt(null);
                    
                    message = patientService.updatePatient(patientDto);
                    
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
                    birthdays = jsonObject.getString("birthday").split(" ");
                    createdAts = jsonObject.getString("createdAt").split(" ");
                    updatedAts = jsonObject.getString("updatedAt").split(" ");
                    
                    birthday = birthdays[5] + "-" + birthdays[1] + "-" + birthdays[2];
                    createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                    updatedAt = updatedAts[5] + "-" + updatedAts[1] + "-" + updatedAts[2];
                    
                    patientDto = new PatientDto(jsonObject);
                    
                    patientDto.setId(jsonObject.getLong("id"));
                    
                    patientDto.setBirthday(new SimpleDateFormat("yyyy-MMM-dd").parse(birthday));
                    patientDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                    patientDto.setUpdatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(updatedAt));
                    patientDto.setDeletedAt(new Date());
                    
                    message = patientService.deletePatient(patientDto);
                    
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
            patientDto.addError("Patient Controller Error:" + e.getMessage());
            if(jsonObject == null){
                jsonObject = new JSONObject();
            }
            
        }
        
        jsonObject.put("errorList", patientDto.getErrorList());
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonObject.toString());

        System.out.println("PatientController.run end");
        // screen redirection.
        return null;
    }
}