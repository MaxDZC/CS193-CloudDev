package sample.dto;

import java.util.ArrayList;


public class MedicalRecordDto {
    
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
    
    
    
    public MedicalRecordDto(String firstName, String lastName, String birthday, String sex, String admissionDate, String disease, ArrayList <Integer> symptoms, ArrayList <Integer> medicines){
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
    
    public void setAdmissionDate(String admissionDate2) {
        this.admissionDate = admissionDate2;
    }
    
    public ArrayList<Integer> getSymptoms() {
        return symptoms;
    }
    
    public void setSymptoms(ArrayList<Integer> symptoms) {
        this.symptoms = symptoms;
    }
    
    public ArrayList<Integer> getMedicines() {
        return medicines;
    }
    
    public void setMedicines(ArrayList<Integer> medicines) {
        this.medicines = medicines;
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
