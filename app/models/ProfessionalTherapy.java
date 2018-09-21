package models;

import scala.Int;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProfessionalTherapy
{
    @Id
    private Integer professtionaltherapyId;
    private Integer therapyId;
    private Integer nameId;


    public ProfessionalTherapy(Integer professtionaltherapyId, Integer therapyId, Integer nameId) {
        this.professtionaltherapyId = professtionaltherapyId;
        this.therapyId = therapyId;
        this.nameId = nameId;
    }

    public Integer getProfesstionaltherapyId() {
        return professtionaltherapyId;
    }

    public Integer getTherapyId() {
        return therapyId;
    }

    public Integer getNameId() {
        return nameId;
    }

    public void setProfesstionaltherapyId(Integer professtionaltherapyId) {
        this.professtionaltherapyId = professtionaltherapyId;
    }

    public void setTherapyId(Integer therapyId) {
        this.therapyId = therapyId;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

}
