package sample.controller;

import java.io.BufferedReader;
import java.io.PrintWriter;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import sample.dto.DoctorDto;
import sample.service.DoctorService;

public class DoctorController extends Controller {

 /**
  * Service object that will be used to call CRUD functions to datastore
  */
 DoctorService doctorService = new DoctorService();


 /**
  * For now, used to insert a 'doctor' entity to the datastore
  */
 @Override
 protected Navigation run() throws Exception {
  System.out.println("DoctorController.run start");

  JSONObject json = new JSONObject();
  String action = request.getParameter("action");
  String method = request.getMethod();
  JSONObject jObj = null;
  
  if(method == "POST"){
        /** 
         * Used to retrieve the JSON equivalent data
         */
        BufferedReader br = request.getReader();
        String str = null;
        StringBuilder sb = new StringBuilder();
        while ((str = br.readLine()) != null) {
            sb.append(str);
        }

        jObj = new JSONObject(sb.toString());
        DoctorDto doctorDto = null;


        /**
         * Used to store the information from the request and send to the
         * service class.
         */
       
   
         doctorDto = new DoctorDto(jObj.getString("fname"),
            jObj.getString("lname"),
            jObj.getString("address"),
            jObj.getString("specialization"),
            "" + jObj.getInt("number") + "",
            jObj.getString("birthday"),
            jObj.getString("username"),
            jObj.getString("password"),
            jObj.getString("email"),
            Long.parseLong(jObj.getString("id"))

        );

        if (action.equals("registerDoctor")) {


            if (doctorService.insertDoc(doctorDto) == false) {

                json.put("message", "duplicated");

            } else {

                json.put("message", true);

            }

        } else if (action.equals("updateDoctor")) {


            if (DoctorService.updateDoctor(doctorDto)) {
                json.put("message", "The Profil of Dr " + jObj.getString("lname") + " was updated ");
            } else {
                json.put("message", false);
            }

        } else if (action.equals("deleteDoctor")) {
            if (DoctorService.deleteDoctor(doctorDto)) {

                json.put("message", "The Profil of Dr " + jObj.getString("lname") + " was deleted ");
            } else {
                json.put("message", false);
            }

        }
  } else if (method == "GET") {
      if(this.request.getParameter("id") != null){
        json.put("doctors", DoctorService.getDoctor(Long.parseLong(this.request.getParameter("id"))));
     } else {
        json.put("doctors", DoctorService.getDoctors());
     }
  }

        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //print JSon
        out.print(json.toString());

        System.out.println("DoctorController.run end");
        //screen redirection.
        return null;
    }
}