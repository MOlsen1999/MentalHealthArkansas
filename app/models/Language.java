package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Language
{
    @Id
    private Integer languageId;
    private String languageName;


    public Integer getLanguageId()
    {
        return languageId;
    }

    public String getLanguageName()
    {
        return languageName;
    }
}
