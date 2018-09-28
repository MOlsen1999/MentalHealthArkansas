package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Suffix
{
    @Id
    private Integer suffixId;
    private String suffix;




    public Integer getSuffixId() {
        return suffixId;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffixId(Integer suffixId) {
        this.suffixId = suffixId;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
