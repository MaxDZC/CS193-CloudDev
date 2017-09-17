package sample.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class MedicalRecordModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    private Long id;

    private String firstName;
    private String lastName;
    private String birthDay;
    private String sex;
    private String admissionDate;
    private String deletedAt;
    private String disease;
    
    private ArrayList <Integer> symptoms;
    
    private ArrayList <Integer> medicines;
    
    public MedicalRecordModel(){
        
    }
    
    public MedicalRecordModel(String firstName, String lastName, String birthday, String sex, String admissionDate, String disease, ArrayList <Integer> symptoms, ArrayList <Integer> medicines){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setBirthDay(birthday);
        this.setSex(sex);
        this.setAdmissionDate(admissionDate);
        this.setDisease(disease);
        this.setSymptoms(symptoms);
        this.setMedicines(medicines);
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthday2) {
        this.birthDay = birthday2;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public ArrayList<Integer> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(ArrayList <Integer> symptoms) {
        this.symptoms = symptoms;
    }

    public ArrayList<Integer> getMedicines() {
        return medicines;
    }

    public void setMedicines(ArrayList<Integer> medicines) {
        this.medicines = medicines;
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

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
