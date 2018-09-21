package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Insurance
{
    @Id
    private Integer insuranceId;
    private Integer insuranceName;

    public Insurance(Integer insuranceId, Integer insuranceName) {
        this.insuranceId = insuranceId;
        this.insuranceName = insuranceName;
    }

    public Integer getInsuranceId() {
        return insuranceId;
    }

    public Integer getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    public void setInsuranceName(Integer insuranceName) {
        this.insuranceName = insuranceName;
    }


}
