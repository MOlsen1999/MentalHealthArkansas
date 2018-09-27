package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProfessionalDiagnosis
{
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer professionaldiagnosisId;
    private Integer nameId;
    private Integer diagnosisId;



    public Integer getProfessionaldiagnosisId()
    {
        return professionaldiagnosisId;
    }

    public Integer getNameId()
    {
        return nameId;
    }

    public Integer getDiagnosisId()
    {
        return diagnosisId;
    }

    public void setProfessionaldiagnosisId(Integer professionaldiagnosisId)
    {
        this.professionaldiagnosisId = professionaldiagnosisId;
    }

    public void setNameId(Integer nameId)
    {
        this.nameId = nameId;
    }

    public void setDiagnosisId(Integer diagnosisId)
    {
        this.diagnosisId = diagnosisId;
    }
}
