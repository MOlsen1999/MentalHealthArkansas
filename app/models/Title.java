package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Title
{
    @Id
    private Integer titleid;
    private String titleName;


    public Title(int titleid, String titleName) {
        this.titleid = titleid;
        this.titleName = titleName;
    }

    public int getTitleid() {
        return titleid;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleid(int titleid) {
        this.titleid = titleid;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
