package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Organization
{  @Id
    private Integer organizationId;
    private Integer organizationName;



    public Integer getOrganizationId() {
        return organizationId;
    }

    public Integer getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public void setOrganizationName(Integer organizationName) {
        this.organizationName = organizationName;
    }

}
