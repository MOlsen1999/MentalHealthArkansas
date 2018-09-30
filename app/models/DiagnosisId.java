package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DiagnosisId
{
    @Id

    private Integer Id;


    public DiagnosisId(Integer id)
    {
        Id = id;
    }

    public Integer getId()
    {
        return Id;
    }
}