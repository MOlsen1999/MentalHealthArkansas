package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Services
{
    @Id
    private Integer servicesId;
    private String servicesName;




    public Integer getServicesId() {
        return servicesId;
    }

    public String getServicesName() {
        return servicesName;
    }

    public void setServicesId(Integer servicesId) {
        this.servicesId = servicesId;
    }

    public void setServicesName(String servicesName) {
        this.servicesName = servicesName;
    }
}
