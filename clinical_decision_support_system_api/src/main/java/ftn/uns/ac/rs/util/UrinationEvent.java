package ftn.uns.ac.rs.util;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class UrinationEvent {

    private Integer amountOfUrination;

    public UrinationEvent(Long patientId, Integer amountOfUrination){
        this.patientId = patientId;
        this.amountOfUrination = amountOfUrination;
    }

    public Integer getAmountOfUrination() {
        return amountOfUrination;
    }

    public void setAmountOfUrination(Integer amountOfUrination) {
        this.amountOfUrination = amountOfUrination;
    }

    private Long patientId;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
