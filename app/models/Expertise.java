package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Expertise
{
    @Id
   private Integer expertiseId;
   private String expertiseName;

    public Expertise(Integer expertiseId, String expertiseName) {
        this.expertiseId = expertiseId;
        this.expertiseName = expertiseName;
    }

    public Integer getExpertiseId() {
        return expertiseId;
    }

    public String getExpertiseName() {
        return expertiseName;
    }

    public void setExpertiseId(Integer expertiseId) {
        this.expertiseId = expertiseId;
    }

    public void setExpertiseName(String expertiseName) {
        this.expertiseName = expertiseName;
    }
}
