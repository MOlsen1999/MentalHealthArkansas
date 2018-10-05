package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MentalHealthProfessionalDetail
{
    @Id
    private Integer nameId;
    private Integer titleId;
    private String titleName;
    private String lastName;
    private String firstName;
    private String address;
    private String city;
    private String stateId;
    private Integer zipcode;
    private Integer minPatientAge;
    private Integer maxPatientAge;
    private Integer suffixId;
    private String suffix;
    private String phoneNumber;
    private Integer languageId;
    private String languageName;
    private Integer expertiseId;
    private String expertiseName;

    private String insuranceName;
    private String therapyName;
    private String diagnosisName;
    private String servicesName;

    public MentalHealthProfessionalDetail()
    {

    }

    public MentalHealthProfessionalDetail(Integer nameId, Integer titleId, String titleName, String lastName, String firstName, String address, String city,
                                          String stateId, Integer zipcode, Integer minPatientAge, Integer maxPatientAge, Integer suffixId, String suffix,
                                          String phoneNumber, Integer languageId, String languageName, Integer expertiseId, String expertiseName,
                                           String insuranceName, String therapyName, String diagnosisName, String servicesName) {

        this.nameId = nameId;
        this.titleId = titleId;
        this.titleName = titleName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.city = city;
        this.stateId = stateId;
        this.zipcode = zipcode;
        this.minPatientAge = minPatientAge;
        this.maxPatientAge = maxPatientAge;
        this.suffixId = suffixId;
        this.suffix = suffix;
        this.phoneNumber = phoneNumber;
        this.languageId = languageId;
        this.languageName= languageName;
        this.expertiseId = expertiseId;
        this.expertiseName = expertiseName;

        this.insuranceName = insuranceName;
        this.therapyName = therapyName;
        this.diagnosisName = diagnosisName;
        this.servicesName = servicesName;



    }

    public void setServicesName(String servicesName) {
        this.servicesName = servicesName;
    }

    public String getServicesName() {
        return servicesName;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName;
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public void setTherapyName(String therapyName) {
        this.therapyName = therapyName;
    }

    public String getTherapyName() {
        return therapyName;
    }



    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }



    public String getInsuranceName() {
        return insuranceName;
    }

    public void setExpertiseId(Integer expertiseId) {
        this.expertiseId = expertiseId;
    }

    public void setExpertiseName(String expertiseName) {
        this.expertiseName = expertiseName;
    }

    public Integer getExpertiseId() {
        return expertiseId;
    }

    public String getExpertiseName() {
        return expertiseName;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Integer getNameId() {
        return nameId;
    }

    public Integer getTitleId() {
        return titleId;
    }

    public String getTitleName() {
        return titleName;
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

    public Integer getMinPatientAge() {
        return minPatientAge;
    }

    public Integer getMaxPatientAge() {
        return maxPatientAge;
    }

    public Integer getSuffixId() {
        return suffixId;
    }


    public String getSuffix()
    {
        return suffix;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
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

    public Integer getLanguageId() {
        return languageId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;

    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public void setZipcode(Integer zipcode) {
        this.zipcode = zipcode;

    }

    public void setMinPatientAge(Integer minPatientAge) {
        this.minPatientAge = minPatientAge;
    }

    public void setMaxPatientAge(Integer maxPatientAge) {
        this.maxPatientAge = maxPatientAge;
    }

    public void setSuffixId(Integer suffixId) {
        this.suffixId = suffixId;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
