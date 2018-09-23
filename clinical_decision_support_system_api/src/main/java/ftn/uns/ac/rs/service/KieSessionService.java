package ftn.uns.ac.rs.service;

import ftn.uns.ac.rs.domain.entity.Illness;
import ftn.uns.ac.rs.domain.entity.Patient;
import ftn.uns.ac.rs.util.DebugAgendaEventListener;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Service
public interface KieSessionService {


    void createNewInstance(String username);

    Illness updateIllnessInSessions(Illness object);
    Patient updatePatientInSessions(Patient object);

    Illness insertIllnessInSessions(Illness object);
    Patient insertPatientInSessions(Patient object);

    void deleteIllnessFromSessions(Long id);
    void deletePatientFromSessions(Long id);

}
