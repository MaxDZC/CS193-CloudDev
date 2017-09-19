package sample.controller;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Date;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import sample.dto.MedicineDto;
import sample.service.MedicineService;

public class MedicineController extends Controller {
    
    /**
    * Service object that will be used to call CRUD functions to datastore
    */
    MedicineService medicineService = new MedicineService();
    
    
    /**
    * For now, used to insert a 'medicine' entity to the datastore
    */
    @Override
    protected Navigation run() throws Exception {
        System.out.println("MedicineController.run start");
        
        JSONObject json = new JSONObject();
        String method = request.getMethod();
        JSONObject jObj = new JSONObject();
        MedicineDto medicineDto = null ;
        
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
            
            /**
            * Used to store the information from the request and send to the
            * service class.
            */
           
             medicineDto = new MedicineDto(
                 jObj.getString("name"),
                 jObj.getString("desc"),
                 Double.parseDouble(jObj.getString("price"))
            );
             medicineDto.setCreatedaAt(new Date());
                
                
                if (medicineService.insertMed(medicineDto) == false) {
                    
                    json.put("message", "duplicated");
                    
                    } else {
                    
                    json.put("message", true);
                    
                }
                
                } else if (method == "PUT") {
        
                    medicineDto = new MedicineDto(jObj.getString("name"),
                        jObj.getString("desc"),
                        Double.parseDouble(jObj.getString("price"))
                        );
                
                    medicineDto.setUpdatedAt(new Date());
                if (MedicineService.updateMedicine(medicineDto)) {
                    json.put("message", "Medicine record updated ");
                    } else {
                    json.put("message", false);
                }
                
                } else if (method == "DELETE") {
                    
                if (MedicineService.deleteMedicine(medicineDto)) {
                    
                    json.put("message", "Medicine record deleted ");
                    } else {
                    json.put("message", false);
                }
                
            }  else if (method == "GET") {
                
            if(this.request.getParameter("name") != null){
                json.put("medicines", MedicineService.getMedicine(this.request.getParameter("name")));
                } else {
                json.put("medicines", MedicineService.getMedicines());
            }
        }
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //print JSon
        out.print(json.toString());
        
        System.out.println("MedicineController.run end");
        //screen redirection.
        return null;
    }
}