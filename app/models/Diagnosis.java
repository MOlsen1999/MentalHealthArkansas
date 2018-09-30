package models;

import scala.Int;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Diagnosis
{
    @Id
    private Integer diagnosisId;
    private String diagnosisName;
    private String description;


    public Integer getDiagnosisId() {
        return diagnosisId;
    }

    public String getDiagnosisName() {
        return diagnosisName;
    }

    public String getDescription() {
        return description;
    }

    public void setDiagnosisId(Integer diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public void setDiagnosisName(String diagnosisName) {
        this.diagnosisName = diagnosisName;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }


}
