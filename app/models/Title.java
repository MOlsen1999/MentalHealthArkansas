package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Title
{
    @Id
    private Integer titleId;
    private String titleName;

    public int getTitleId()
    {
        return titleId;
    }

    public String getTitleName()
    {
        return titleName;
    }

    public void setTitleId(int titleId)
    {
        this.titleId = titleId;
    }

    public void setTitleName(String titleName)
    {
        this.titleName = titleName;
    }
}
