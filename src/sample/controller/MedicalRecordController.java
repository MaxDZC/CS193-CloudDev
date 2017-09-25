package sample.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;
import org.slim3.util.RequestMap;

import sample.dto.MedicalRecordDto;
import sample.service.MedicalRecordService;




public class MedicalRecordController extends Controller {

    @Override
    public Navigation run() throws Exception {
        System.out.println("MedicalRecordController.run start");
        
        String method = request.getMethod();
        JSONObject jObj = new JSONObject();
        MedicalRecordDto medicalRecordDto = new MedicalRecordDto();
        MedicalRecordService medicalRecordService = new MedicalRecordService();
       
        String[] dischargeDates;
        String[] createdAts;
        String[] updatedAts;
        String dischargeDate;
        String createdAt;
        String updatedAt;
        Date dischargeDateNew;
        Date createdAtNew;
        Date updatedAtNew;
        Object checkerObj;
        
        try{
            if(method.equals("POST")){
                jObj = new JSONObject(request.getReader().readLine());
                
                medicalRecordDto = new MedicalRecordDto(jObj);
                dischargeDate = jObj.getString("dischargeDate").split("T")[0];
                medicalRecordDto.setDischargeDate(new SimpleDateFormat("yyyy-MM-dd").parse(dischargeDate));
                medicalRecordDto.setCreatedAt(new Date());
                medicalRecordService.insertMedicalRecord(medicalRecordDto);
                
            } else if(method.equalsIgnoreCase("GET")){
                jObj = new JSONObject(new RequestMap(this.request));
                System.out.println("MedicalRecord Get");
                if(jObj.has("doctorId")){
                    System.out.println("MedicalRecord Get doctorID");
                    jObj.put("medicalRecords", medicalRecordService.getMedicalRecordByDoctorId(jObj.getLong("doctorId")));   
                } else {
                    System.out.println("MedicalRecord Get list of medicalRecords");
                    jObj.put("medicalRecords", medicalRecordService.getMedicalRecords());
                }
                
            } else if(method.equals("PUT")) {
                jObj = new JSONObject(request.getReader().readLine());
                medicalRecordDto = new MedicalRecordDto(jObj);
                
                checkerObj = jObj.get("dischargeDate");
                
                if(checkerObj instanceof String){
                    dischargeDates = jObj.getString("dischargeDate").split(" ");
                    createdAts = jObj.getString("createdAt").split(" ");
                
                    dischargeDate = dischargeDates[5] + "-" + dischargeDates[1] + "-" + dischargeDates[2];
                    createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                    
                    medicalRecordDto.setDischargeDate(new SimpleDateFormat("yyyy-MMM-dd").parse(dischargeDate));
                    medicalRecordDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                } else {
                    dischargeDateNew = new Date(jObj.getLong("birthday"));
                    createdAtNew = new Date(jObj.getLong("createdAt"));
                    
                    medicalRecordDto.setDischargeDate(dischargeDateNew);
                    medicalRecordDto.setCreatedAt(createdAtNew);
                }
                
                medicalRecordDto.setId(jObj.getLong("id"));
                medicalRecordDto.setUpdatedAt(new Date());
                medicalRecordService.deleteOrUpdateMedicalRecord(medicalRecordDto);
                
            }else if(method.equals("DELETE")){
                jObj = new JSONObject(request.getReader().readLine());
                medicalRecordDto = new MedicalRecordDto(jObj);
                
                checkerObj = jObj.get("dischargeDate");
                
                if(checkerObj instanceof String){
                    dischargeDates = jObj.getString("birthday").split(" ");
                    createdAts = jObj.getString("createdAt").split(" ");
                    
                    dischargeDate = dischargeDates[5] + "-" + dischargeDates[1] + "-" + dischargeDates[2];
                    createdAt = createdAts[5] + "-" + createdAts[1] + "-" + createdAts[2];
                    
                    medicalRecordDto.setDischargeDate(new SimpleDateFormat("yyyy-MMM-dd").parse(dischargeDate));
                    medicalRecordDto.setCreatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(createdAt));
                    
                    if(jObj.has("updatedAt")){
                        updatedAts = jObj.getString("updatedAt").split(" ");
                        updatedAt = updatedAts[5] + "-" + updatedAts[1] + "-" + updatedAts[2];
                        medicalRecordDto.setUpdatedAt(new SimpleDateFormat("yyyy-MMM-dd").parse(updatedAt));
                    }
                    
                } else {
                    dischargeDateNew = new Date(jObj.getLong("dischargeDate"));
                    createdAtNew = new Date(jObj.getLong("createdAt"));            
                    
                    medicalRecordDto.setDischargeDate(dischargeDateNew);
                    medicalRecordDto.setCreatedAt(createdAtNew);
                    
                    if(jObj.has("updatedAt")){ 
                        updatedAtNew = new Date(jObj.getLong("updated At")); 
                        medicalRecordDto.setUpdatedAt(updatedAtNew);
                    }
                }
                
                medicalRecordDto.setId(jObj.getLong("id"));
                medicalRecordDto.setDeletedAt(new Date());
                
                medicalRecordService.deleteOrUpdateMedicalRecord(medicalRecordDto);
            }
            
        } catch(Exception e){
            System.err.println(e.toString());
            // Adds error message if it exists
            medicalRecordDto.addError("MedicalRecord Controller Error:" + e.getMessage());
        }
        
        jObj.put("errorList", medicalRecordDto.getErrorList());
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(jObj.toString());

        System.out.println("MedicalRecordController.run end");
        // screen redirection.
        return null;
    }
}
