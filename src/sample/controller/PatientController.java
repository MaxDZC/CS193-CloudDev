package sample.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import sample.dto.PatientDto;
import sample.meta.PatientModelMeta;
import sample.service.MedicalRecordService;
import sample.service.PatientService;
import sample.utils.JSONValidators;

public class PatientController extends Controller {
    /**
    * Service object that will be used to call CRUD functions to datastore
    */
    PatientService patientService = new PatientService();
    MedicalRecordService medicalRecordService = new MedicalRecordService();

    @Override
    protected Navigation run() throws Exception {
        System.out.println("PatientController.run start");

        PatientDto patientDto = new PatientDto();
        JSONObject jsonObject = new JSONObject();
        JSONValidators validator;
        
        String birthday;
        String createdAt;
        String updatedAt;
        String[] birthdays;
        String[] createdAts;
        String[] updatedAts;
        Date birthdayNew;
        Date createdAtNew;
        Date updatedAtNew;
        Object anObj;

        String method = request.getMethod();
        boolean message;
        
        try{

            if(method.equals("POST")){
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    
                    patientDto = new PatientDto(jsonObject);
                    
                    birthday = jsonObject.getString("birthday").split("T")[0];
                    patientDto.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
                    patientDto.setCreatedAt(new Date());
                    
                    message = patientService.insertPatient(patientDto);
                    
                    if (message) {
                        jsonObject.put("success", message);
                    } else {
                        jsonObject.put("errors", message);
                        response.setStatus(400);
                    }
                
                }

            } else if(method.equals("GET")) {
                jsonObject = new JSONObject(new RequestMap(this.request));
                
                if(jsonObject.has("diseaseId")){
                    jsonObject.put("patient", PatientModelMeta.get().modelToJson(PatientService.getPatient(jsonObject.getLong("diseaseId"))));
                } else {
                    jsonObject.put("patients", PatientService.getPatients());
                    jsonObject.put("medicalRecords", medicalRecordService.getMedicalRecords());
                }
                
            } else if(method.equals("PUT")) {
                
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    
                    patientDto = new PatientDto(jsonObject);
                    anObj = jsonObject.get("birthday");
                    
                    if(anObj instanceof String){
                        birthdays = jsonObject.getString("birthday").split(" ");
                        createdAts = jsonObject.getString("createdAt").split(" ");
                    
                        birthday = birthdays[5] + "-" + birthdays[1] + "-" + birthdays[2];
                        createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                        
                        patientDto.setBirthday(new SimpleDateFormat("yyyy-MMM-dd").parse(birthday));
                        patientDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                    } else {
                        birthdayNew = new Date(jsonObject.getLong("birthday"));
                        createdAtNew = new Date(jsonObject.getLong("createdAt"));
                        
                        patientDto.setBirthday(birthdayNew);
                        patientDto.setCreatedAt(createdAtNew);
                    }
                    
                    patientDto.setId(jsonObject.getLong("id"));
                    patientDto.setUpdatedAt(new Date());
                    
                    message = patientService.updatePatient(patientDto);
                    
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
                    patientDto = new PatientDto(jsonObject);
                    anObj = jsonObject.get("createdAt");
                    
                    if(anObj instanceof String){
                        birthdays = jsonObject.getString("birthday").split(" ");
                        createdAts = jsonObject.getString("createdAt").split(" ");
                        
                        birthday = birthdays[5] + "-" + birthdays[1] + "-" + birthdays[2];
                        createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                        
                        patientDto.setBirthday(new SimpleDateFormat("yyyy-MMM-dd").parse(birthday));
                        patientDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                        
                        if(jsonObject.has("updatedAt")){
                            updatedAts = jsonObject.getString("updatedAt").split(" ");
                            updatedAt = updatedAts[5] + "-" + updatedAts[1] + "-" + updatedAts[2];
                            patientDto.setUpdatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(updatedAt));
                        }
                        
                    } else {
                        birthdayNew = new Date(jsonObject.getLong("birthday"));
                        createdAtNew = new Date(jsonObject.getLong("createdAt"));            
                        
                        patientDto.setBirthday(birthdayNew);
                        patientDto.setCreatedAt(createdAtNew);
                        
                        if(jsonObject.has("updatedAt")){ 
                            updatedAtNew = new Date(jsonObject.getLong("updated At")); 
                            patientDto.setUpdatedAt(updatedAtNew);
                        }
                    }
                    
                    patientDto.setId(jsonObject.getLong("id"));
                    patientDto.setDeletedAt(new Date());
                    
                    message = patientService.deletePatient(patientDto);
                    
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
            patientDto.addError("Patient Controller Error:" + e.getMessage());
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