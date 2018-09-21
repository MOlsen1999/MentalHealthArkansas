package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProfessionalDiagnosis
{
    @Id
    private Integer professionaldiagnosisId;
    private Integer nameId;
    private Integer diagnosisId;

    public ProfessionalDiagnosis(Integer professionaldiagnosisId, Integer nameId, Integer diagnosisId) {
        this.professionaldiagnosisId = professionaldiagnosisId;
        this.nameId = nameId;
        this.diagnosisId = diagnosisId;
    }

    public Integer getProfessionaldiagnosisId() {
        return professionaldiagnosisId;
    }

    public Integer getNameId() {
        return nameId;
    }

    public Integer getDiagnosisId() {
        return diagnosisId;
    }

    public void setProfessionaldiagnosisId(Integer professionaldiagnosisId) {
        this.professionaldiagnosisId = professionaldiagnosisId;
    }

    public void setNameId(Integer nameId) {
        this.nameId = nameId;
    }

    public void setDiagnosisId(Integer diagnosisId) {
        this.diagnosisId = diagnosisId;
    }
}
