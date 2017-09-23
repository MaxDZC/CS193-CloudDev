package sample.dto;

import java.util.Date;

import org.slim3.repackaged.org.json.JSONObject;

public class PatientDto extends ErrorsDto{
    /**
     * The id of the 'Patient'
     */
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String contactNo;
    private Date birthday;  
    private boolean sex;
    private Date createdAt;
    private Date deletedAt;
    private Date updatedAt;
    
    public PatientDto(){
        
    }
    
    public PatientDto(JSONObject jObj) throws Exception {
        this.setFirstname(jObj.getString("firstname"));
        this.setLastname(jObj.getString("lastname"));
        this.setAddress(jObj.getString("address"));
        this.setContactNo(jObj.getString("contactNo"));
        this.setSex(jObj.getBoolean("sex"));
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getLastname() {
        return lastname;
    }
    
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getContactNo() {
        return contactNo;
    }
    
    public void setContactNo(String contactNo) {
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
