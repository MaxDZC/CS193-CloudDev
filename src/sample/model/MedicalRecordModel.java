package sample.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import sample.dto.MedicalRecordDto;

@Model(schemaVersion = 1)
public class MedicalRecordModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    //This is only set when creating/inserting
    private Long id;
    
    //Should be set regardless of service or action
    private Long doctorId;
    private Long patientId;
    
    private ArrayList <Long> symptomIdList;
    private ArrayList <Long> medicineIdList;
    private ArrayList <Long> diseaseIdList;
    private ArrayList <Long> quantityList;
    private Boolean type;
    
    private Date dischargeDate;
    private Date createdAt; //initialize only when created
    private Date updatedAt; //initialize only when updated
    private Date deletedAt; //initialize only when deleted
    
    public MedicalRecordModel(){
        
    }
    
    public MedicalRecordModel(MedicalRecordDto inputMedicalRecord){
        this.setDoctorId(inputMedicalRecord.getDoctorId());
        this.setPatientId(inputMedicalRecord.getPatientId());
        
        this.setMedicineIdList(inputMedicalRecord.getMedicineIdList());
        this.setSymptomIdList(inputMedicalRecord.getSymptomIdList());
        this.setDiseaseIdList(inputMedicalRecord.getDiseaseIdList());
        this.setQuantityList(inputMedicalRecord.getQuantityList());
        
        this.setDischargeDate(inputMedicalRecord.getDischargeDate());
    }
    
    

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
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

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MedicalRecordModel other = (MedicalRecordModel) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

}
