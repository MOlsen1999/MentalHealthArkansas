package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Organization
{  @Id
    private Integer organizationId;
    private String  organizationName;



    public Integer getOrganizationId() {
        return organizationId;
    }

    public String  getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public void setOrganizationName(String  organizationName) {
        this.organizationName = organizationName;
    }

}
