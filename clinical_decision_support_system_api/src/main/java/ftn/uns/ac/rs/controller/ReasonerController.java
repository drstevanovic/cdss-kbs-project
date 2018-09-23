package ftn.uns.ac.rs.controller;

import ftn.uns.ac.rs.domain.dto.PatientsSymptoms;
import ftn.uns.ac.rs.domain.dto.ResponseDto;
import ftn.uns.ac.rs.domain.dto.SearchDto;
import ftn.uns.ac.rs.domain.entity.IllnessSymptom;
import ftn.uns.ac.rs.domain.entity.Patient;
import ftn.uns.ac.rs.service.PatientService;
import ftn.uns.ac.rs.util.DebugAgendaEventListener;
import ftn.uns.ac.rs.util.Sort;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "/api/reasoner")
public class ReasonerController {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private HashMap<String, KieSession> sessions;

    @Autowired
    private PatientService patientService;

    @PostMapping(value = "/start")
    public ResponseEntity<?> startReasoner(@RequestBody PatientsSymptoms symptoms) throws ParseException {
        KieSession session = sessions.get((String) servletContext.getAttribute("currentUser"));

        Patient patient = patientService.findByJmbg(symptoms.getPatient().getJmbg());
        symptoms.setPatient(patient);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(new Date());
        symptoms.setCurrentDate(sdf.parse(dateStr));

        session.insert(symptoms);
        session.getAgenda().getAgendaGroup("probability_illness").setFocus();
        session.fireAllRules(1);

        AgendaEventListener listener = (AgendaEventListener) session.getAgendaEventListeners().toArray()[0];
        int len = ((DebugAgendaEventListener) listener).getFiredRules().size();
        if (len > 0) {
            String foundIllness = ((DebugAgendaEventListener) listener).getFiredRules().get(0).toString();
            ((DebugAgendaEventListener) listener).deleteFiredRules();
            System.out.println("Nadjeno " + foundIllness);
            return ResponseEntity.accepted().body(foundIllness);
        } else {
            return ResponseEntity.accepted().body("No illness meets this symptoms.");
        }
    }

    @PostMapping(value = "/start/symptoms")
    public ResponseEntity<?> startReasonerForSymptoms(@RequestBody PatientsSymptoms symptoms) {
        String currentUser = (String) servletContext.getAttribute("currentUser");

        KieSession session = sessions.get(currentUser);
        session.fireAllRules();

        Map<String, Integer> foundIllnesses = new HashMap<>();
        QueryResults results = null;
        results = session.getQueryResults("getIllnessForSymptoms", symptoms.getSymptoms());
        for (QueryResultsRow result : results) {
            HashMap<String, Integer> rowMap = (HashMap<String, Integer>) result.get("foundIllnesses");
            if (rowMap.entrySet().iterator().hasNext()) {
                Map.Entry<String, Integer> temp = rowMap.entrySet().iterator().next();
                foundIllnesses.put(temp.getKey(), temp.getValue());
            }

        }
        foundIllnesses = Sort.sortMapByValue(foundIllnesses);
        List<ResponseDto> responseDtos = new ArrayList<>();
        for (Map.Entry<String, Integer> i : foundIllnesses.entrySet()) {
            responseDtos.add(new ResponseDto(i.getKey(), i.getValue()));
        }
        return ResponseEntity.accepted().body(responseDtos);

    }

    @PostMapping(value = "/start/illness")
    public ResponseEntity<?> startReasonerForIllness(@RequestBody SearchDto searchDto) {
        String currentUser = (String) servletContext.getAttribute("currentUser");

        KieSession session = sessions.get(currentUser);
        session.fireAllRules();
        Map<String, Boolean> foundSymptoms = new HashMap<>();

        QueryResults results = null;
        results = session.getQueryResults("getSymptomsForIllness", searchDto.getSearchValue());
        for (QueryResultsRow result : results) {
            ArrayList<IllnessSymptom> foundList = (ArrayList<IllnessSymptom>) result.get("foundSymptoms");
            for (IllnessSymptom is : foundList) {
                foundSymptoms.put(is.getSymptom().getName(), is.isOrdinary());
            }
        }
        foundSymptoms = Sort.sortMapByValue(foundSymptoms);
        List<ResponseDto> responseDtos = new ArrayList<>();
        for (Map.Entry<String, Boolean> i : foundSymptoms.entrySet()) {
            if (i.getValue()) {
                responseDtos.add(new ResponseDto(i.getKey(), "ordinary"));

            } else {
                responseDtos.add(new ResponseDto(i.getKey(), "specific"));
            }
        }

        return ResponseEntity.accepted().body(responseDtos);

    }
}
