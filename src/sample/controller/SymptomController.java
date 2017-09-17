package sample.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONException;
import org.slim3.repackaged.org.json.JSONObject;

import sample.dto.SymptomDto;
import sample.model.SymptomModel;
import sample.service.SymptomService;

public class SymptomController extends Controller {
    
    /**
     * Service object that will be used to call CRUD functions to datastore
     */
    SymptomService SymptomService = new SymptomService();
    ArrayList<SymptomModel> retVal;
    JSONObject json;
    /**
     * For now, used to insert a 'Symptom' entity to the datastore
     */
    @Override
    protected Navigation run() throws Exception {
        System.out.println("SymptomController.run start");
        String method = request.getMethod();
        
        try{
            /**
             * Used to retrieve the JSON equivalent data
             */
            if("POST".equalsIgnoreCase(method)){
                addSymptom();
            }else if("GET".equalsIgnoreCase(method)){
                getAllSymptom();
            } else if("DELETE".equalsIgnoreCase(method)){
                
            }
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();     
            //print JSon
            out.print(json.toString());
        }catch(Exception e){
            System.out.println("SymptomController.run.exception: "+e.toString());
        }
        
        System.out.println("SymptomController.run end");
        //screen redirection.
        return forward("/app/components/editSymptom/editSymptom.html/");
    }
    public boolean addSymptom(){
        boolean ret = true;
        try {
            
            json = new JSONObject(request.getReader().readLine());
            SymptomDto dto = new SymptomDto();
            dto.setName(json.getString("symptomName"));
            if(SymptomService.insertSymp(dto)){
                System.out.println("add Symptom Successfully");
            } else {
                System.out.println("add Symptom fail");
                ret = false;
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ret;
    }
    public void getAllSymptom(){
        try {
            json.put("symptomList",SymptomService.getAllSymp().toString());
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
