package sample.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import sample.dto.DoctorDto;
import sample.meta.DoctorModelMeta;
import sample.service.DoctorService;
import sample.service.MedicalRecordService;
import sample.utils.JSONValidators;

public class DoctorController extends Controller {

    /**
    * Service object that will be used to call CRUD functions to datastore
    */
    DoctorService doctorService = new DoctorService();
    MedicalRecordService medicalRecordService = new MedicalRecordService();

    @Override
    protected Navigation run() throws Exception {
        System.out.println("DoctorController.run start");

        DoctorDto doctorDto = new DoctorDto();
        JSONObject jsonObject = null;
        JSONValidators validator;
        
        String birthday;
        String createdAt;
        String updatedAt;
        String[] birthdays;
        String[] createdAts;
        String[] updatedAts;

        String method = request.getMethod();
        String message;
        
        try{
        /* \   DoctorDto adminAccount = new DoctorDto();
            
            adminAccount.setFirstname("admin");
            adminAccount.setLastname("admin");
            adminAccount.setAddress("Sto. Nino Village, Road 1 Zone Sikwa Pakna-an, Mandaue City");
            adminAccount.setAdmin(true);
            adminAccount.setUsername("root");
            adminAccount.setPassword("root");
            adminAccount.setSpecialization("Administrator");
            adminAccount.setContactNo("09323437269");
            adminAccount.setEmail("teambob.cloud@gmail.com");
            
            adminAccount.setCreatedAt(new Date());
            adminAccount.setDeletedAt(null);
            adminAccount.setUpdatedAt(null);
            
            message = doctorService.insertDoc(adminAccount);
            jsonObject = new JSONObject();
            method = "";
        */
            
            if(method.equalsIgnoreCase("POST")){
                jsonObject = new JSONObject(this.request.getReader().readLine());

                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    
                    doctorDto = new DoctorDto(jsonObject);
                    
                    birthday = jsonObject.getString("birthday").split("T")[0];
                    
                    doctorDto.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
                    doctorDto.setCreatedAt(new Date());
                    doctorDto.setUpdatedAt(null);
                    doctorDto.setDeletedAt(null);
                    
                    message = doctorService.insertDoc(doctorDto);
                    
                    if (message.equals("")) {
                        jsonObject.put("success", true);
                    } else {
                        jsonObject.put("errors", message);
                        response.setStatus(400);
                    }
                
                }

            } else if(method == "GET") {
                jsonObject = new JSONObject(new RequestMap(this.request));
                
                if(jsonObject.has("username")){
                    Object tester = DoctorService.loginDoctor(jsonObject.getString("username"), jsonObject.getString("password"));
                    if(tester != null){
                        String doc = DoctorModelMeta.get().modelToJson(tester);
                        System.out.println(doc);
                        JSONObject jsonResult = new JSONObject(doc);
                        long doctorId = jsonResult.getLong("id");
                        jsonObject.put("doctor", doc);
                        jsonObject.put("doctorMedicalRecords", MedicalRecordService.getMedicalRecordByDoctorId(doctorId));
                        System.out.println(MedicalRecordService.getMedicalRecordByDoctorId((long) 627));
                    } else {
                       response.setStatus(400);
                    }
                } else {
                    jsonObject.put("doctors", DoctorService.getDoctors());
                    jsonObject.put("medicalRecords", MedicalRecordService.getMedicalRecords());
                }
                
            } else if(method == "PUT") {
                
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                
                
                if(validator.validate()){
                    
                    birthdays = jsonObject.getString("birthday").split(" ");
                    createdAts = jsonObject.getString("createdAt").split(" ");
                    
                    birthday = birthdays[5] + "-" + birthdays[1] + "-" + birthdays[2];
                    createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                    
                    doctorDto = new DoctorDto(jsonObject);
                    
                    
                    doctorDto.setId(jsonObject.getLong("id"));
                    
                    doctorDto.setBirthday(new SimpleDateFormat("yyyy-MMM-dd").parse(birthday));
                    doctorDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                    doctorDto.setUpdatedAt(new Date());
                    doctorDto.setDeletedAt(null);
                    
                    message = doctorService.updateDoctor(doctorDto);
                    
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
                    birthdays = jsonObject.getString("birthday").split(" ");
                    createdAts = jsonObject.getString("createdAt").split(" ");
                    updatedAts = jsonObject.getString("updatedAt").split(" ");
                    
                    birthday = birthdays[5] + "-" + birthdays[1] + "-" + birthdays[2];
                    createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                    updatedAt = updatedAts[5] + "-" + updatedAts[1] + "-" + updatedAts[2];
                    
                    doctorDto = new DoctorDto(jsonObject);
                    
                    doctorDto.setId(jsonObject.getLong("id"));
                    
                    doctorDto.setBirthday(new SimpleDateFormat("yyyy-MMM-dd").parse(birthday));
                    doctorDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                    doctorDto.setUpdatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(updatedAt));
                    doctorDto.setDeletedAt(new Date());
                    
                    message = doctorService.deleteDoctor(doctorDto);
                    
                    if(message.equals("")){
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
            doctorDto.addError("Doctor Controller Error:" + e.getMessage());
            if(jsonObject == null){
                jsonObject = new JSONObject();
            }
            
        }
        
        jsonObject.put("errorList", doctorDto.getErrorList());
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonObject.toString());

        System.out.println("DoctorController.run end");
        // screen redirection.
        return null;
    }
}