package sample.model;

import java.io.Serializable;
import java.util.Date;


import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class DoctorModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
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

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
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
        DoctorModel other = (DoctorModel) obj;
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
