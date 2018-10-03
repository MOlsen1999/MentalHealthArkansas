package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NewNameId
{
    @Id
private Integer Id;

    public NewNameId(Integer id)
    {
        Id = id;
    }

    public Integer getId()
    {
        return Id;
    }
}
