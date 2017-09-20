package sample.model;

import java.io.Serializable;
import java.util.Date;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

import sample.dto.PatientDto;

@Model(schemaVersion = 1)
public class PatientModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;
    
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String contactNo;
    private Date birthday;
    private boolean sex;
    private String createdAt;
    private String deletedAt;
    private String updatedAt;
    
    public PatientModel(){
        
    }
    
    public PatientModel(PatientDto inputPatient){
        this.setFirstname(inputPatient.getFirstName());
        this.setLastname(inputPatient.getLastName());
        this.setAddress(inputPatient.getAddress());
        this.setBirthday(inputPatient.getBirthday());
        this.setContactNo(inputPatient.getContactNumber());
        this.setSex(inputPatient.isSex());
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


    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public String getCreatedAt() {
        return createdAt;
    }


    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }


    public String getDeletedAt() {
        return deletedAt;
    }


    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }


    public String getUpdatedAt() {
        return updatedAt;
    }


    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    
    /**
     * Creates an instance of 'Patient' with attribute initialization
     */
    
    
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
        PatientModel other = (PatientModel) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }
    
    /**
     * Returns the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Sets the id.
     *
     * @param id
     *            the id
     */
    public void setId(Long id) {
        this.id = id;
    }
    
}
