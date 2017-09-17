package sample.controller;

import java.util.ArrayList;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

import sample.dto.MedicalRecordDto;
import sample.service.MedicalRecordService;



public class MedicalRecordController extends Controller {

    @Override
    public Navigation run() throws Exception {
        System.out.println("MedicalRecordController.run start");
        
        String method = request.getMethod();
        JSONObject jObj = null;
        MedicalRecordDto medicalRecordDto = null;
        MedicalRecordService medicalRecordService = new MedicalRecordService();
        
        try{
            if(method.equalsIgnoreCase("POST")){
                jObj = new JSONObject(request.getReader().readLine());
                
                ArrayList <Integer> tempSymptoms = new ArrayList<Integer>();
                
                
                for(int i=0;i < jObj.getJSONArray("symptomChoice").length(); i++){
                   if(jObj.getJSONArray("symptomChoice").get(i).toString() == "true"){
                       tempSymptoms.add(i);
                   }
                }
                
                ArrayList <Integer> tempMedicines = new ArrayList<Integer>();
                
                
                for(int i=0;i < jObj.getJSONArray("medicineChoice").length(); i++){
                    if(jObj.getJSONArray("medicineChoice").get(i).toString() == "true"){
                        tempMedicines.add(i);
                    }
                }
                
                medicalRecordDto = new MedicalRecordDto(
                        jObj.getString("firstName").toLowerCase(),//store as lower case in order to ignore casing during comparison
                        jObj.getString("lastName").toLowerCase(),//store as lower case in order to ignore casing during comparison
                        jObj.getString("birthday"),
                        jObj.getString("sex"),
                        jObj.getString("admissionDate"),
                        jObj.getString("disease").toLowerCase(),
                        tempSymptoms,//should originally contain the ID of the corresponding symptoms
                        tempMedicines//should originally contain the ID of the corresponding medicines
                    );
                
                medicalRecordService.insertMedicalRecord(medicalRecordDto);
                /*For testing purposes*/
                medicalRecordService.deleteMedicalRecord(/*Insert the Dto here*/);
                medicalRecordService.updateMedicalRecord(/*Insert the Dto here*/);
            }else if(method.equalsIgnoreCase("PUT")){
            
            }else if(method.equalsIgnoreCase("DELETE")){
            
            }else if(method.equalsIgnoreCase("GET")){
            
            }
            System.out.println("MedicalRecordController.run end");
        }catch(Exception e){
            System.out.println("MedicalRecordController Exception: "+e.toString());
            
        }
        return null;
    }
}
