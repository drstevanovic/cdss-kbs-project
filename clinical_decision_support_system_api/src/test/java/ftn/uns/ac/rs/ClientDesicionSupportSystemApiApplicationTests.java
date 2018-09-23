package ftn.uns.ac.rs;

import com.mysql.jdbc.log.LogFactory;
import ftn.uns.ac.rs.domain.entity.Patient;
import ftn.uns.ac.rs.service.PatientService;
import ftn.uns.ac.rs.util.DebugAgendaEventListener;
import ftn.uns.ac.rs.util.HeartBeatEvent;
import ftn.uns.ac.rs.util.OxygenEvent;
import ftn.uns.ac.rs.util.UrinationEvent;
import org.drools.core.time.SessionPseudoClock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.security.x509.URIName;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientDesicionSupportSystemApiApplicationTests {

    @Autowired
    private PatientService patientService;

    private KieSession kieSession;

    @Before
    public void initKession() {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("clinical_decision_support_system_rules", "clinical_decision_support_system_rules-kjar", "0.0.1-SNAPSHOT"));

        kieSession = kContainer.newKieSession("monitoringConfigPseudo");
        kieSession.addEventListener(new DebugAgendaEventListener());
        for (Patient p : patientService.findAll()) {
            kieSession.insert(p);
        }
    }

    @Test
    public void oxygen() {
        SessionPseudoClock clock = kieSession.getSessionClock();

        kieSession.insert(new OxygenEvent(1L, 100));
        clock.advanceTime(5, TimeUnit.MINUTES);
        assertThat(kieSession.fireAllRules(), equalTo(0));

        kieSession.insert(new OxygenEvent(1L, 60));
        clock.advanceTime(16, TimeUnit.MINUTES);
        // proslo 15 minuta
        assertThat(kieSession.fireAllRules(), equalTo(1));
        kieSession.insert(new OxygenEvent(1L, 50));

    }


    @Test
    public void heartBeat() {
        SessionPseudoClock clock = kieSession.getSessionClock();
        // 4 puta, kad dodje do 25 pa 26,27,28
        int countOfFiredRules = 0;
        for (int index = 0; index < 28; index++) {
            // da se ne bi okidao za kiseonik ako
            kieSession.insert(new OxygenEvent(1L, 100));
            HeartBeatEvent beep = new HeartBeatEvent(1L);
            kieSession.insert(beep);
            clock.advanceTime(380, TimeUnit.MILLISECONDS);
            countOfFiredRules += kieSession.fireAllRules();
        }
        assertThat(countOfFiredRules, equalTo(4));

    }

    @Test
    public void dialysis() {
        int countOfFiredRules = 0;
        SessionPseudoClock clock = kieSession.getSessionClock();

        kieSession.insert(new UrinationEvent(1L, 50));
        clock.advanceTime(11, TimeUnit.HOURS);
        countOfFiredRules += kieSession.fireAllRules();
        assertThat(countOfFiredRules, equalTo(0));
        clock.advanceTime(11, TimeUnit.HOURS);
        countOfFiredRules += kieSession.fireAllRules();
        assertThat(countOfFiredRules, equalTo(0));
        for (int index = 0; index < 12; index++) {
            HeartBeatEvent beep = new HeartBeatEvent(6L);
            kieSession.insert(beep);
            clock.advanceTime(800, TimeUnit.MILLISECONDS);
            countOfFiredRules += kieSession.fireAllRules();
        }
        // za 10,11,12
        assertThat(countOfFiredRules, equalTo(3));


    }
}
