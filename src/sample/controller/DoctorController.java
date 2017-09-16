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

        String action = request.getParameter("action");
        String method = request.getMethod();
        String message;

        try{

            if(method == "POST"){
                /** 
                * Used to retrieve the JSON equivalent data
                */
                jsonObject = new JSONObject(this.request.getReader().readLine());

                validator = new JSONValidators(jsonObject);
                /**
                * Used to store the information from the request and send to the
                * service class.
                */
                if(validator.validate()){
                    
                    doctorDto.setFirstName(jsonObject.getString("firstname"));
                    doctorDto.setLastName(jsonObject.getString("lastname"));
                    doctorDto.setEmail(jsonObject.getString("email"));
                    doctorDto.setAddress(jsonObject.getString("address"));
                    doctorDto.setSpecialization(jsonObject.getString("specialization"));
                    doctorDto.setContactNo(jsonObject.getString("contactNo"));
                    doctorDto.setBirthday(new SimpleDateFormat("dd/MM/yyyy").parse(jsonObject.getString("birthday")));
                    doctorDto.setUsername(jsonObject.getString("username"));
                    doctorDto.setPassword(jsonObject.getString("username"));
                    doctorDto.setToken(jsonObject.getString("username"));
                    doctorDto.setAdmin(false);
                    doctorDto.setCreatedAt(new Date());
                    doctorDto.setUpdatedAt(new Date());
                    doctorDto.setDeletedAt(null);
                    
                    message = doctorService.insertDoc(doctorDto);
                    
                    if (message.equals("")) {
                        jsonObject.put("success", true);
                    } else {
                        response.setStatus(400);
                        jsonObject.put("errorList", message);
                    }
                
                }
            

                    if (action.equals("updateDoctor")) {


                    if (DoctorService.updateDoctor(doctorDto)) {
                        jsonObject.put("message", "The Profil of Dr " + jsonObject.getString("lname") + " was updated ");
                    } else {
                        jsonObject.put("message", false);
                    }

                } else if (action.equals("deleteDoctor")) {
                    if (DoctorService.deleteDoctor(doctorDto)) {

                        jsonObject.put("message", "The Profil of Dr " + jsonObject.getString("lname") + " was deleted ");
                    } else {
                        jsonObject.put("message", false);
                    }

                }
            } else if (method == "GET") {
                
                jsonObject = new JSONObject(this.request.getReader().readLine());
                
                if(this.request.getParameter("id") != null){
                    jsonObject.put("doctors", DoctorService.getDoctor(Long.parseLong(this.request.getParameter("id"))));
                } else {
                    jsonObject.put("doctors", DoctorService.getDoctors());
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