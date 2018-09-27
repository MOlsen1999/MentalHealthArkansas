package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Insurance
{
    @Id
    private Integer insuranceId;
    private String insuranceName;



    public Integer getInsuranceId() {
        return insuranceId;
    }

    public String getInsuranceName()
    {
        return insuranceName;
    }

    public void setInsuranceId(Integer insuranceId)
    {
        this.insuranceId = insuranceId;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }


}
