package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InsuranceAccepted
{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer insuranceacceptedId;
    private Integer nameId;
    private Integer insuranceId;




    public Integer getInsuranceacceptedId()
    {
        return insuranceacceptedId;
    }

    public Integer getNameId() {
        return nameId;

    }

    public Integer getInsuranceId()
    {
        return insuranceId;
    }

    public void setInsuranceacceptedId(Integer insuranceacceptedId) {
        this.insuranceacceptedId = insuranceacceptedId;
    }

    public void setNameId(Integer nameId)
    {
        this.nameId = nameId;
    }

    public void setInsuranceId(Integer insuranceId)
    {
        this.insuranceId = insuranceId;
    }
}
