package ftn.uns.ac.rs.util;

import org.kie.api.definition.type.Role;

@Role(Role.Type.EVENT)
public class OxygenEvent {

    private Integer oxygenLevel;

    public OxygenEvent(Long patiendId, Integer oxygenLevel){
        this.oxygenLevel = oxygenLevel;
        this.patientId = patiendId;
    }
    public Integer getOxygenLevel() {
        return oxygenLevel;
    }

    public void setOxygenLevel(Integer oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }

    private Long patientId;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
