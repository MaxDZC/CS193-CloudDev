package sample.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONArray;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import sample.dto.DiseaseDto;
import sample.meta.DiseaseModelMeta;
import sample.meta.DoctorModelMeta;
import sample.service.DiseaseService;
import sample.service.DoctorService;
import sample.service.MedicalRecordService;
import sample.utils.JSONValidators;

public class DiseaseController extends Controller {
    JSONObject jsonObject;
    static DiseaseService diseaseService = new DiseaseService();
    JSONArray sympId; 
    JSONArray medId;
    String diseaseName;
    JSONValidators validator;
    DiseaseDto diseaseDto;
    String createdAt;
    String updatedAt;
    String[] createdAts;
    String[] updatedAts;
    boolean message;
    @Override
    public Navigation run() throws Exception {
        String method = request.getMethod();
        System.out.println("WHAATTTT1");
        try{
            if("POST".equalsIgnoreCase(method)){
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                if(validator.validate()){
                    JSONArray sympId = jsonObject.getJSONArray("symptomId");
                    JSONArray medId = jsonObject.getJSONArray("medicineId");
                    List<Long> idsymptoms = new ArrayList<Long>();
                    List<Long> idmedicines = new ArrayList<Long>();
                    diseaseName = jsonObject.getString("name");
                    
                    for(int i=0;i<sympId.length();i++){
                        idsymptoms.add(sympId.getJSONObject(i).getLong("id"));
                        System.out.println("symp: " +sympId.getJSONObject(i).getLong("id"));
                    }
                    for(int i=0;i<medId.length();i++){
                        idmedicines.add(medId.getJSONObject(i).getLong("id"));
                    }
                    if(idmedicines!=null && idsymptoms!=null){
                        System.out.println("HELLO");
                        DiseaseDto dto = new DiseaseDto();
                        dto.setMedicineId(idmedicines);
                        dto.setSymptomId(idsymptoms);
                        dto.setName(diseaseName);
                        diseaseService.insertDisease(dto);
                    }
                }
            }  else if(method == "GET") {
                jsonObject = new JSONObject(new RequestMap(this.request));
                if(jsonObject.has("id")){
                    System.out.println("Getting Single Disease");
                    diseaseName= jsonObject.getString("name");
                    jsonObject.put("disease", DiseaseModelMeta.get().modelToJson(diseaseService.getDisease(diseaseName)));
                } else {
                    System.out.println("Getting All Diseases");
                    jsonObject.put("diseases", diseaseService.getAllDisease());
                }
            } else if(method == "PUT") {
                
                jsonObject = new JSONObject(this.request.getReader().readLine());
                validator = new JSONValidators(jsonObject);
                
                
                
                if(validator.validate()){
                    
                    createdAts = jsonObject.getString("createdAt").split(" ");
                    
                    createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                    
                    diseaseDto = new DiseaseDto(jsonObject);
                    
                    
                    diseaseDto.setId(jsonObject.getLong("id"));
                    
                    diseaseDto.setUpdatedAt(new Date());
                    diseaseDto.setDeletedAt(null);
                    
                    message = diseaseService.updateDisease(diseaseDto);
                    
                    if(message){
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
                    //createdAts = jsonObject.getString("createdAt").split(" ");
                    //updatedAts = jsonObject.getString("updatedAt").split(" ");
                    
                    //createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                    //updatedAt = updatedAts[5] + "-" + updatedAts[1] + "-" + updatedAts[2];
                    
                    diseaseDto = new DiseaseDto(jsonObject);
                    
                    diseaseDto.setId(jsonObject.getLong("medicineId"));
                    
                    //diseaseDto.setUpdatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(updatedAt));
                    diseaseDto.setDeletedAt(new Date());
                    
                    message = diseaseService.deleteDisease(diseaseDto);
                    
                    if(message){
                        jsonObject.put("success", true);    
                    } else {
                        response.setStatus(400);
                        jsonObject.put("errors", message);
                    }
                }
            }


        }catch(Exception e){
            e.printStackTrace();
        }
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jsonObject.toString());

        return null;
    }           
}
