package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Suffix
{
    @Id
    private Integer siffixId;
    private String suffix;


    public Suffix(Integer siffixId, String suffix) {
        this.siffixId = siffixId;
        this.suffix = suffix;
    }

    public Integer getSiffixId() {
        return siffixId;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSiffixId(Integer siffixId) {
        this.siffixId = siffixId;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
