package models;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProfessionalServices
{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer professionalservicesId;
    private Integer nameId;
    private Integer servicesId;


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
