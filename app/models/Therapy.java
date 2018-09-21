package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Therapy
{
    @Id
    private Integer therapyId;
    private String therapyName;

    public Therapy(Integer therapyId, String therapyName) {
        this.therapyId = therapyId;
        this.therapyName = therapyName;
        }

    public Integer getTherapyId() {
        return therapyId;
    }

    public String getTherapyName() {
        return therapyName;
    }

    public void setTherapyId(Integer therapyId) {
        this.therapyId = therapyId;
    }

    public void setTherapyName(String therapyName) {
        this.therapyName = therapyName;
    }
}
