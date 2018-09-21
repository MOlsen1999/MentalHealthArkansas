package models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class State
{
    @Id
    private String stateId;
    private String stateName;

    public State(String stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public String getStateId() {
        return stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
