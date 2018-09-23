package ftn.uns.ac.rs.controller;

import ftn.uns.ac.rs.domain.dto.ReportDto;
import ftn.uns.ac.rs.domain.entity.Patient;
import ftn.uns.ac.rs.service.PatientService;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "/api/reports")
public class ReportContoller {

    @Autowired
    private ServletContext servletContext;

    @Autowired private HashMap<String, KieSession> sessions;

    @GetMapping(value = "/chronic-patients")
    public ResponseEntity<?> getChronicPatients() {
        String currentUser = (String)servletContext.getAttribute("currentUser");

        KieSession session = sessions.get(currentUser);
        session.fireAllRules();


        HashSet<Patient> foundPatients = new HashSet<>();
        QueryResults results = null;
        results = session.getQueryResults("getChronicPatients", 1000 * 60 * 60 * 24);
        for (QueryResultsRow result : results) {
            foundPatients.add((Patient)result.get("chronicPatients"));
        }
        List<ReportDto> patients = new ArrayList<>();
        for(Patient p: foundPatients){
            System.out.println(p.getJmbg());
            patients.add(new ReportDto(p.getJmbg(), p.getFirstName(),p.getLastName()));
        }
        return ResponseEntity.ok(patients);

    }

    @GetMapping(value = "/addict-patients")
    public ResponseEntity<?> getPotentialAddict() {
        String currentUser = (String)servletContext.getAttribute("currentUser");

        KieSession session = sessions.get(currentUser);
        session.fireAllRules();

        HashSet<Patient> foundPatients = new HashSet<>();
        QueryResults results = null;
        results = session.getQueryResults("getAddictPatients", 1000 * 60 * 60 * 24);
        for (QueryResultsRow result : results) {
            foundPatients.add((Patient)result.get("addictPatients"));
        }
        List<ReportDto> patients = new ArrayList<>();
        for(Patient p: foundPatients){
            System.out.println(p.getJmbg());
            patients.add(new ReportDto(p.getJmbg(), p.getFirstName(),p.getLastName()));
        }
        return ResponseEntity.ok(patients);
    }

    @GetMapping(value = "/immunity")
    public ResponseEntity<?> getWithoutImmunity() {
        String currentUser = (String)servletContext.getAttribute("currentUser");

        KieSession session = sessions.get(currentUser);
        session.fireAllRules();

        HashSet<Patient> foundPatients = new HashSet<>();
        QueryResults results = null;
        results = session.getQueryResults("getAntibioticsForDiffIllness", 1000 * 60 * 60 * 24);
        for (QueryResultsRow result : results) {
            foundPatients.add((Patient)result.get("withAntibiotics"));
            System.out.println(((Patient) result.get("withAntibiotics")).getJmbg());
        }
        System.out.println("-----------------------------------");
        results = session.getQueryResults("getPatientsWithAllAntibiotics", 1000 * 60 * 60 * 24);
        for (QueryResultsRow result : results) {
            for(Patient p: (HashSet<Patient>)result.get("patients")){
                System.out.println(p.getJmbg());
                foundPatients.add(p);
            }
        }
        System.out.println("-----------------------------------");

        List<ReportDto> patients = new ArrayList<>();
        for(Patient p: foundPatients){
            System.out.println(p.getJmbg());
            patients.add(new ReportDto(p.getJmbg(), p.getFirstName(),p.getLastName()));
        }
        return ResponseEntity.ok(patients);

    }


}
