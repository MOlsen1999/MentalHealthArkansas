package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MentalHealthProfessionalDetail
{
    @Id
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

    public MentalHealthProfessionalDetail(String titleName, String lastName, String firstName, String address, String city, String stateId, Integer zipcode, Integer minPatientAge, Integer maxPatientAge, Integer suffixId, String suffix) {
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
}
