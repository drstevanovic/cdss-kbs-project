package ftn.uns.ac.rs.util;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class HeartBeatEvent {

    public HeartBeatEvent(Long patientId){
        this.patientId = patientId;
    }

    private Long patientId;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
