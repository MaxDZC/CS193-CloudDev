package sample.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import sample.dto.DoctorDto;
import sample.meta.DoctorModelMeta;
import sample.model.DoctorModel;
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
        Object aObj;

        String method = request.getMethod();
        String message;
        
        try{
          /*  DoctorDto adminAccount = new DoctorDto();
            
            adminAccount.setFirstname("Administrator");
            adminAccount.setLastname("Max");
            adminAccount.setAddress("Sto. Nino Village, Road 1 Zone Sikwa Pakna-an, Mandaue City");
            adminAccount.setAdmin(true);
            adminAccount.setUsername("root");
            adminAccount.setPassword("root");
            adminAccount.setSpecialization("Administrator");
            adminAccount.setContactNo("09323437269");
            adminAccount.setEmail("teambob.cloud@gmail.com");
            adminAccount.setBirthday(new Date());
            
            
            adminAccount.setCreatedAt(new Date());
            adminAccount.setDeletedAt(null);
            adminAccount.setUpdatedAt(null);
            
            message = doctorService.insertDoc(adminAccount);
            jsonObject = new JSONObject();
            method = "";
            */
        
            
            if(method.equals("POST")){
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()) {
                    doctorDto = new DoctorDto(jsonObject);
                    
                    birthday = jsonObject.getString("birthday").split("T")[0];
                    
                    doctorDto.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
                    doctorDto.setCreatedAt(new Date());
                    
                    message = doctorService.insertDoc(doctorDto);
                    
                    if (message.equals("")) {
                        jsonObject.put("success", true);
                    } else {
                        jsonObject.put("errors", message);
                        response.setStatus(400);
                    }
                
                }

            } else if(method.equals("GET")) {
                jsonObject = new JSONObject(new RequestMap(this.request));
                
                if(jsonObject.has("username")) {
                    DoctorModel doctorModel = doctorService.loginDoctor(jsonObject.getString("username"), jsonObject.getString("password"));
                    //Object tester = doctorService.loginDoctor(jsonObject.getString("username"), jsonObject.getString("password"));
                    if(doctorModel != null){
                        List<DoctorModel> dm = new ArrayList<DoctorModel>();
                        dm.add(doctorModel);
                       // String doc = DoctorModelMeta.get().modelToJson(tester);
                       // System.out.println(doc);
                       // JSONObject jsonResult = new JSONObject(doc);
                       // long doctorId = jsonResult.getLong("id");
                        System.out.println("What");
                        jsonObject.put("doctor", dm);
                        jsonObject.put("doctorMedicalRecords", medicalRecordService.getMedicalRecordByDoctorId(doctorModel.getId()));
                    } else {
                       response.setStatus(400);
                    }
                } else {
                    jsonObject.put("doctors", doctorService.getDoctors());
                    jsonObject.put("medicalRecords", medicalRecordService.getMedicalRecords());
                }
                
            } else if(method.equals("PUT")) {                
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    doctorDto = new DoctorDto(jsonObject);
                    aObj = jsonObject.get("birthday");
                    
                    if(aObj instanceof String){
                        birthdays = jsonObject.getString("birthday").split(" ");
                        createdAts = jsonObject.getString("createdAt").split(" ");
                    
                        birthday = birthdays[5] + "-" + birthdays[1] + "-" + birthdays[2];
                        createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                        
                        doctorDto.setBirthday(new SimpleDateFormat("yyyy-MMM-dd").parse(birthday));
                        doctorDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                    } else {
                        birthdayNew = new Date(jsonObject.getLong("birthday"));
                        createdAtNew = new Date(jsonObject.getLong("createdAt"));
                        
                        doctorDto.setBirthday(birthdayNew);
                        doctorDto.setCreatedAt(createdAtNew);
                    }
                    
                    doctorDto.setId(jsonObject.getLong("id"));
                    doctorDto.setUpdatedAt(new Date());
                    
                    message = doctorService.updateDoctor(doctorDto);
                    
                    if(message.equals("")){
                        jsonObject.put("success", true);
                    } else {
                        jsonObject.put("errors", message);
                        response.setStatus(400);
                    }
                }
                    
            } else if(method.equals("DELETE")) {
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){             
                    doctorDto = new DoctorDto(jsonObject);
                    aObj = jsonObject.get("birthday");
                    
                    if(aObj instanceof String){
                        birthdays = jsonObject.getString("birthday").split(" ");
                        createdAts = jsonObject.getString("createdAt").split(" ");
                    
                        birthday = birthdays[5] + "-" + birthdays[1] + "-" + birthdays[2];
                        createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                        
                        doctorDto.setBirthday(new SimpleDateFormat("yyyy-MMM-dd").parse(birthday));
                        doctorDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                        
                        if(jsonObject.has("updatedAt")){
                            updatedAts = jsonObject.getString("updatedAt").split(" ");
                            updatedAt = updatedAts[5] + "-" + updatedAts[1] + "-" + updatedAts[2];
                            doctorDto.setUpdatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(updatedAt));
                        }
                    } else {
                        birthdayNew = new Date(jsonObject.getLong("birthday"));
                        createdAtNew = new Date(jsonObject.getLong("createdAt"));
                        
                        doctorDto.setBirthday(birthdayNew);
                        doctorDto.setCreatedAt(createdAtNew);
                        
                        if(jsonObject.has("updatedAt")){
                            updatedAtNew = new Date(jsonObject.getLong("updatedAt"));
                            doctorDto.setUpdatedAt(updatedAtNew);
                        }
                    }
                    
                    doctorDto.setId(jsonObject.getLong("id"));
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