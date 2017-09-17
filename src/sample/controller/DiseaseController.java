package sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONArray;
import org.slim3.repackaged.org.json.JSONException;
import org.slim3.repackaged.org.json.JSONObject;

import sample.dto.DiseaseDto;
import sample.service.DiseaseService;

public class DiseaseController extends Controller {
    JSONObject json;
    static DiseaseService diseaseService = new DiseaseService();
    @Override
    public Navigation run() throws Exception {
        String method = request.getMethod();
        System.out.println("WHAATTTT1");
        if("POST".equalsIgnoreCase(method)){
            System.out.println("WHAATTTT");
            json = new JSONObject(request.getReader().readLine());
            System.out.println(json);
            insertDisease(json.getJSONArray("symptomsid"),json.getJSONArray("medicineid"), json.getString("diseasename"));
            json.put("message","insert Success");
        }
        
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json.toString());

        return null;
    }
    private void insertDisease(JSONArray sympId, JSONArray medId, String diseaseName) {
        // TODO Auto-generated method stub
        List<Long> idsymptoms = new ArrayList<Long>();
        List<Long> idmedicines = new ArrayList<Long>();
        for(int i=0;i<sympId.length();i++){
            try {
                idsymptoms.add(sympId.getJSONObject(i).getLong("id"));
                System.out.println("symp: " +sympId.getJSONObject(i).getLong("id"));
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        for(int i=0;i<medId.length();i++){
            try {
                idmedicines.add(medId.getJSONObject(i).getLong("id"));
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
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
        
        
}
