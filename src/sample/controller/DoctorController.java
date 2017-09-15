package sample.controller;

import java.io.BufferedReader;
import java.io.PrintWriter;

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
                doctorDto = new DoctorDto(jsonObject.getString("fname"),
                    jsonObject.getString("lname"),
                    jsonObject.getString("address"),
                    jsonObject.getString("specialization"),
                    "" + jsonObject.getInt("number") + "",
                    jsonObject.getString("birthday"),
                    jsonObject.getString("username"),
                    jsonObject.getString("password"),
                    jsonObject.getString("email"),
                    Long.parseLong(jsonObject.getString("id"))

                );
            
                if (action.equals("registerDoctor")) {


                    if (doctorService.insertDoc(doctorDto) == false) {

                        jsonObject.put("message", "duplicated");

                    } else {

                        jsonObject.put("message", true);

                    }

                } else if (action.equals("updateDoctor")) {


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