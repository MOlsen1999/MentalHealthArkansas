package models;



import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProfessionalServices
{
    @Id
    private Integer professionalservicesId;
    private Integer nameId;
    private Integer servicesId;

    public ProfessionalServices(Integer professionalservicesId, Integer nameId, Integer servicesId) {
        this.professionalservicesId = professionalservicesId;
        this.nameId = nameId;
        this.servicesId = servicesId;
    }

    public Integer getProfessionalservicesId() {
        return professionalservicesId;
    }

    public Integer getNameId() {
        return nameId;
    }

    public Integer getServicesId() {
        return servicesId;
    }

    public void setProfessionalservicesId(Integer professionalservicesId) {
        this.professionalservicesId = professionalservicesId;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public void setServicesId(Integer servicesId) {
        this.servicesId = servicesId;
    }
}
