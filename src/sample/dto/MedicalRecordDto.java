package sample.dto;

import java.util.ArrayList;
import java.util.Date;

import org.slim3.repackaged.org.json.JSONArray;
import org.slim3.repackaged.org.json.JSONObject;


public class MedicalRecordDto extends ErrorsDto{
    
    private Long id;
    
    //Should be set regardless of service or action
    private Long doctorId;
    private Long patientId;
    
    private ArrayList <Long> symptomIdList;
    private ArrayList <Long> medicineIdList;
    private ArrayList <Long> diseaseIdList;
    private ArrayList <Long> quantityList;
    private Boolean inPatient;
    
    private Date dischargeDate;
    private Date createdAt; //initialize only when created
    private Date updatedAt; //initialize only when updated
    private Date deletedAt; //initialize only when deleted
    
    public MedicalRecordDto(){
        
    }

    public MedicalRecordDto(JSONObject jObj) throws Exception {
        ArrayList <Long> tempMedIdList = new ArrayList<Long>();
        ArrayList <Long> tempDisIdList = new ArrayList<Long>();
        ArrayList <Long> tempSymIdList = new ArrayList<Long>();
        ArrayList <Long> tempQuantityList = new ArrayList<Long>();
        JSONArray sympIdList = jObj.getJSONArray("symptomIdList");
        JSONArray medIdList = jObj.getJSONArray("medicineIdList");
        JSONArray disIdList = jObj.getJSONArray("diseaseIdList");
        JSONArray quantityList = jObj.getJSONArray("quantityList");
        int i;
        
        for(i = 0; i < sympIdList.length(); i++){
            tempSymIdList.add(sympIdList.getLong(i));
        }
        
        for(i = 0; i < medIdList.length(); i++){
            tempMedIdList.add(medIdList.getLong(i));
        }
        
        for(i = 0; i < disIdList.length(); i++){
            tempDisIdList.add(disIdList.getLong(i));
        }

        for(i = 0; i < quantityList.length(); i++){
            tempQuantityList.add(quantityList.getLong(i));
        }
        
        this.setDoctorId(jObj.getLong("doctorId"));
        this.setPatientId(jObj.getLong("patientId"));
        this.setMedicineIdList(tempMedIdList);
        this.setSymptomIdList(tempSymIdList);
        this.setDiseaseIdList(tempDisIdList);
        this.setQuantityList(tempQuantityList);
        this.setInPatient(jObj.getBoolean("inPatient"));
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public ArrayList<Long> getSymptomIdList() {
        return symptomIdList;
    }

    public void setSymptomIdList(ArrayList<Long> symptomIdList) {
        this.symptomIdList = symptomIdList;
    }

    public ArrayList<Long> getMedicineIdList() {
        return medicineIdList;
    }

    public void setMedicineIdList(ArrayList<Long> medicineIdList) {
        this.medicineIdList = medicineIdList;
    }

    public ArrayList<Long> getDiseaseIdList() {
        return diseaseIdList;
    }

    public void setDiseaseIdList(ArrayList<Long> diseaseIdList) {
        this.diseaseIdList = diseaseIdList;
    }

    public ArrayList<Long> getQuantityList() {
        return quantityList;
    }

    public void setQuantityList(ArrayList<Long> quantityList) {
        this.quantityList = quantityList;
    }

    public Boolean getInPatient() {
        return inPatient;
    }

    public void setInPatient(Boolean inPatient) {
        this.inPatient = inPatient;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
    
    
}
