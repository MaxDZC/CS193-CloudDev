package sample.dto;

import java.util.Date;

import org.slim3.repackaged.org.json.JSONObject;

public class DoctorDto extends ErrorsDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String specialization;
    private String contactNo;
    private Date birthday;
    private String username;
    private String password;
    private String token;
    private boolean isAdmin;
    private Date createdAt;
    private Date deletedAt;
    private Date updatedAt;
    
    public DoctorDto(){
        
    }
    
    public DoctorDto(JSONObject obj) throws Exception{
        this.setFirstname(obj.getString("firstname"));
        this.setLastname(obj.getString("lastname"));
        this.setEmail(obj.getString("email"));
        this.setAddress(obj.getString("address"));
        this.setSpecialization(obj.getString("specialization"));
        this.setContactNo(obj.getString("contactNo"));
      
        this.setUsername(obj.getString("username"));
        this.setPassword(obj.getString("password"));
        this.setAdmin(false);
        this.setToken(null);
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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
