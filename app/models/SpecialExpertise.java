package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class SpecialExpertise
{
    @Id
   private Integer expertiseId;
   private String expertiseName;



    public Integer getExpertiseId()
    {
        return expertiseId;
    }

    public String getExpertiseName()
    {
        return expertiseName;
    }

    public void setExpertiseId(Integer expertiseId) {
        this.expertiseId = expertiseId;
    }

    public void setExpertiseName(String expertiseName) {
        this.expertiseName = expertiseName;
    }
}
