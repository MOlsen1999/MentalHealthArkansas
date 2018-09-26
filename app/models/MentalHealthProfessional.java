package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MentalHealthProfessional
{  @Id
    private Integer nameId;
    private Integer titleId;
    private String lastName;
    private String firstName;
    private String address;
    private String city;
    private String stateId;
    private Integer zipcode;
    private Integer organizationId;
    private Integer minPatientAge;
    private Integer maxPatientAge;
    private Integer expertiseId;
    private Integer suffixId;
    private String phoneNumber;
    private Integer languageId;





    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public Integer getNameId() {
        return nameId;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getStateId() {
        return stateId;
    }

    public Integer getZipcode() {
        return zipcode;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public Integer getMinPatientAge() {
        return minPatientAge;
    }

    public Integer getMaxPatientAge() {
        return maxPatientAge;
    }

    public Integer getExpertiseId() {
        return expertiseId;
    }

    public Integer getSuffixId() {
        return suffixId;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public void setMinPatientAge(Integer minPatientAge) {
        this.minPatientAge = minPatientAge;
    }

    public void setMaxPatientAge(Integer maxPatientAge) {
        this.maxPatientAge = maxPatientAge;
    }

    public void setExpertiseId(Integer expertiseId) {
        this.expertiseId = expertiseId;
    }

    public void setSuffixId(Integer suffixId) {
        this.suffixId = suffixId;
    }
}
