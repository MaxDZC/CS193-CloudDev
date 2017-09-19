package sample.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    public MedicalRecordDto(JSONObject jObj) throws Exception{
        this.setDoctorId(jObj.getLong("doctorId"));
        this.setPatientId(jObj.getLong("patientId"));
        
        ArrayList <Long> tempMedIdList = new ArrayList <Long>();
        for(int i=0; i < jObj.getJSONArray("medicineIdList").length(); i++){
            tempMedIdList.add(jObj.getJSONArray("medicineIdList").getLong(i));
        }
        
        ArrayList <Long> tempDisIdList = new ArrayList <Long>();
        for(int i=0; i < jObj.getJSONArray("diseaseIdList").length(); i++){
            tempDisIdList.add(jObj.getJSONArray("diseaseIdList").getLong(i));
        }
        
        ArrayList <Long> tempSymIdList = new ArrayList <Long>();
        for(int i=0; i < jObj.getJSONArray("symptomIdList").length(); i++){
            tempSymIdList.add(jObj.getJSONArray("symptomIdList").getLong(i));
        }
        
        ArrayList <Long> tempQuantityList = new ArrayList <Long>();
        for(int i=0; i < jObj.getJSONArray("quantityList").length(); i++){
            tempQuantityList.add(jObj.getJSONArray("quantityList").getLong(i));
        }
        
        this.setMedicineIdList(tempMedIdList);
        this.setSymptomIdList(tempSymIdList);
        this.setDiseaseIdList(tempDisIdList);
        this.setQuantityList(tempQuantityList);
        
        String dischargeDate = jObj.getString("dischargeDate").split("T")[0];
        
        this.setDischargeDate(new SimpleDateFormat("yyyy-MM-dd").parse(dischargeDate));
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
