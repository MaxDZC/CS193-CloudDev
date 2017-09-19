package sample.dto;

import java.util.Date;

import org.slim3.repackaged.org.json.JSONObject;

public class PatientDto extends ErrorsDto{
    /**
     * The id of the 'Patient'
     */
    private Long id;
    
    /**
     * The firstName of the 'Patient'
     */
    private String firstname;
    
    /**
     * The lastName of the 'Patient'
     */
    private String lastname;
    
    /**
     * The address of the 'Patient'
     */
    private String address;
    
    /**
     * The contactNumber of the 'Patient'
     */
    private String contactNo;
    
    /**
     * The birthDay of the 'Patient'
     */
    private Date birthday;
    
    private boolean sex;
    
    
    /**
     * Creates an instance of 'Patient'
     */
    private Date createdAt;
    private Date deletedAt;
    private Date updatedAt;
    
    public PatientDto(){
        
    }
    
    public PatientDto(JSONObject jObj) throws Exception{
        this.setFirstName(jObj.getString("firstname"));
        this.setLastName(jObj.getString("lastname"));
        this.setAddress(jObj.getString("address"));
        this.setSex(jObj.getBoolean("sex"));
        this.setContactNumber(jObj.getString("contactNo"));
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstname;
    }
    
    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }
    
    public String getLastName() {
        return lastname;
    }
    
    public void setLastName(String lastName) {
        this.lastname = lastName;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getContactNumber() {
        return contactNo;
    }
    
    public void setContactNumber(String contactNo) {
        this.contactNo = contactNo;
    }
    
    public Date getBirthday() {
        return birthday;
    }
    
    public void setBirthday(Date date) {
        this.birthday = date;
    }
    
    public boolean isSex() {
        return sex;
    }
    
    public void setSex(boolean sex) {
        this.sex = sex;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(Date createdaAt) {
        this.createdAt = createdaAt;
    }
    
    public Date getDeletedAt() {
        return deletedAt;
    }
    
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
    
    public Date getUpdatedAt() {
        return updatedAt;
    }
    
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
       
}
