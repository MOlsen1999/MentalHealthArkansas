package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InsuranceAccepted
{
    @Id
    private Integer insuranceacceptedId;
    private Integer nameId;
    private Integer insuranceId;


    public InsuranceAccepted(Integer insuranceacceptedId, Integer nameId, Integer insuranceId) {
        this.insuranceacceptedId = insuranceacceptedId;
        this.nameId = nameId;
        this.insuranceId = insuranceId;
    }

    public Integer getInsuranceacceptedId() {
        return insuranceacceptedId;
    }

    public Integer getNameId() {
        return nameId;
    }

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceacceptedId(Integer insuranceacceptedId) {
        this.insuranceacceptedId = insuranceacceptedId;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }
}
