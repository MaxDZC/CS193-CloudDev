package sample.controller;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import sample.dto.DoctorDto;
import sample.service.DoctorService;
import sample.utils.JSONValidators;

public class DoctorController extends Controller {

    /**
    * Service object that will be used to call CRUD functions to datastore
    */
    DoctorService doctorService = new DoctorService();

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

            if(method == "POST"){
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    
                    birthday = jsonObject.getString("birthday").split("T")[0];
                    
                    doctorDto.setFirstname(jsonObject.getString("firstname"));
                    doctorDto.setLastname(jsonObject.getString("lastname"));
                    doctorDto.setEmail(jsonObject.getString("email"));
                    doctorDto.setAddress(jsonObject.getString("address"));
                    doctorDto.setSpecialization(jsonObject.getString("specialization"));
                    doctorDto.setContactNo(jsonObject.getString("contactNo"));
                    doctorDto.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
                    doctorDto.setUsername(jsonObject.getString("username"));
                    doctorDto.setPassword(jsonObject.getString("password"));
                    doctorDto.setToken(null);
                    doctorDto.setAdmin(false);
                    doctorDto.setCreatedAt(new Date());
                    doctorDto.setUpdatedAt(new Date());
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
                jsonObject = new JSONObject();
                jsonObject.put("doctors", DoctorService.getDoctors());
            
            } else if(method == "PUT") {
                
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    
                    birthdays = jsonObject.getString("birthday").split(" ");
                    createdAts = jsonObject.getString("createdAt").split(" ");
                    
                    birthday = birthdays[5] + "-" + birthdays[1] + "-" + birthdays[2];
                    createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                    
                    doctorDto.setId(jsonObject.getLong("id"));
                    doctorDto.setFirstname(jsonObject.getString("firstname"));
                    doctorDto.setLastname(jsonObject.getString("lastname"));
                    doctorDto.setEmail(jsonObject.getString("email"));
                    doctorDto.setAddress(jsonObject.getString("address"));
                    doctorDto.setSpecialization(jsonObject.getString("specialization"));
                    doctorDto.setContactNo(jsonObject.getString("contactNo"));
                    doctorDto.setBirthday(new SimpleDateFormat("yyyy-MMM-dd").parse(birthday));
                    doctorDto.setUsername(jsonObject.getString("username"));
                    doctorDto.setPassword(jsonObject.getString("password"));
                    doctorDto.setToken(null);
                    doctorDto.setAdmin(false);
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
                    
                } else if(method == "DELETE"){
                    
                    birthdays = jsonObject.getString("birthday").split(" ");
                    createdAts = jsonObject.getString("createdAt").split(" ");
                    updatedAts = jsonObject.getString("updatedAt").split(" ");
                    
                    birthday = birthdays[5] + "-" + birthdays[1] + "-" + birthdays[2];
                    createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                    updatedAt = updatedAts[5] + "-" + updatedAts[1] + "-" + updatedAts[2];
                    
                    doctorDto.setId(jsonObject.getLong("id"));
                    doctorDto.setFirstname(jsonObject.getString("firstname"));
                    doctorDto.setLastname(jsonObject.getString("lastname"));
                    doctorDto.setEmail(jsonObject.getString("email"));
                    doctorDto.setAddress(jsonObject.getString("address"));
                    doctorDto.setSpecialization(jsonObject.getString("specialization"));
                    doctorDto.setContactNo(jsonObject.getString("contactNo"));
                    doctorDto.setBirthday(new SimpleDateFormat("yyyy-MMM-dd").parse(birthday));
                    doctorDto.setUsername(jsonObject.getString("username"));
                    doctorDto.setPassword(jsonObject.getString("password"));
                    doctorDto.setToken(null);
                    doctorDto.setAdmin(false);
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