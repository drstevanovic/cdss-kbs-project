package ftn.uns.ac.rs.service.serviceImpl;

import ftn.uns.ac.rs.domain.entity.Illness;
import ftn.uns.ac.rs.domain.entity.Patient;
import ftn.uns.ac.rs.service.IllnessService;
import ftn.uns.ac.rs.service.KieSessionService;
import ftn.uns.ac.rs.service.PatientService;
import ftn.uns.ac.rs.util.DebugAgendaEventListener;
import org.drools.core.common.DefaultFactHandle;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.HashMap;

@Service
public class KieSessionServiceImpl implements KieSessionService {
    @Autowired
    private ServletContext servletContext;

    @Autowired
    private KieContainer kieContainer;

    @Autowired
    private HashMap<String, KieSession> sessions;

    @Autowired
    private IllnessService illnessService;

    @Autowired
    private PatientService patientService;

    @Override
    public void createNewInstance(String username) {
        KieSession kieSession = kieContainer.newKieSession("ksession-rules");
        loadIlnesses(kieSession);
        loadPatients(kieSession);
        kieSession.addEventListener(new DebugAgendaEventListener());
        sessions.put(username, kieSession);
        servletContext.setAttribute("currentUser", username);
    }

    @Override
    public Illness updateIllnessInSessions(Illness illness) {
        for (KieSession ks : sessions.values()) {
            for (FactHandle factHandle : ks.getFactHandles()) {
                Object obj = ((DefaultFactHandle) factHandle).getObject();
                if (obj.getClass().equals(Illness.class)) {
                    if (((Illness) obj).getId().equals(illness.getId())) {
                        ks.update(factHandle, illness);
                        return illness;
                    }
                }
            }
        }
        return illness;
    }

    @Override
    public Patient updatePatientInSessions(Patient object) {
        for (KieSession ks : sessions.values()) {
            for (FactHandle factHandle : ks.getFactHandles()) {
                Object obj = ((DefaultFactHandle) factHandle).getObject();
                if (obj.getClass().equals(Patient.class)) {
                    if (((Patient) obj).getId().equals(object.getId())) {
                        ks.update(factHandle, object);
                        return object;
                    }
                }
            }
        }
        return object;
    }

    @Override
    public Illness insertIllnessInSessions(Illness object) {
        for (KieSession ks : sessions.values()) {
            ks.insert(object);
        }
        return object;
    }

    @Override
    public Patient insertPatientInSessions(Patient object) {
        for (KieSession ks : sessions.values()) {
            ks.insert(object);
        }
        return object;
    }

    @Override
    public void deleteIllnessFromSessions(Long id) {
        for (KieSession ks : sessions.values()) {
            for (FactHandle factHandle : ks.getFactHandles()) {
                Object obj = ((DefaultFactHandle) factHandle).getObject();
                if (obj.getClass().equals(Illness.class) && ((Illness) obj).getId().equals(id)) {
                    ks.delete(factHandle);
                }
            }
        }
    }

    @Override
    public void deletePatientFromSessions(Long id) {
        for (KieSession ks : sessions.values()) {
            for (FactHandle factHandle : ks.getFactHandles()) {
                Object obj = ((DefaultFactHandle) factHandle).getObject();
                if (obj.getClass().equals(Patient.class)) {
                    if (((Patient) obj).getId().equals(id)) {
                        ks.delete(factHandle);
                    }
                }
            }
        }
    }

    public void loadPatients(KieSession kieSession) {
        for (Patient p : patientService.findAll()) {
            kieSession.insert(p);
        }
    }

    public void loadIlnesses(KieSession kieSession) {
        for (Illness i : illnessService.getAll()) {
            kieSession.insert(i);
        }
    }


}
