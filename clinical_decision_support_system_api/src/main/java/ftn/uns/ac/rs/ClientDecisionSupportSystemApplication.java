package ftn.uns.ac.rs;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;

@SpringBootApplication
public class ClientDecisionSupportSystemApplication {

	@Bean
	public HashMap<String, KieSession> getSessions(){
		return new HashMap<>();
	}

	@Bean
	public KieContainer kieContainer() {
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("clinical_decision_support_system_rules", "clinical_decision_support_system_rules-kjar", "0.0.1-SNAPSHOT"));
		KieScanner kScanner = ks.newKieScanner(kContainer);
		kScanner.start(10000);
		return kContainer;
	}

//	@Bean
//	public KieSession kieSession() {
//		KieServices ks = KieServices.Factory.get();
//		KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("clinical_decision_support_system_rules", "clinical_decision_support_system_rules-kjar", "0.0.1-SNAPSHOT"));
//		KieScanner kScanner = ks.newKieScanner(kContainer);
//		kScanner.start(10000);
//		KieSession kieSession = kContainer.newKieSession();
//		return kieSession;
//	}

	public static void main(String[] args) {
		SpringApplication.run(ClientDecisionSupportSystemApplication.class, args);

	}


}
