package ftn.uns.ac.rs.controller;

import ftn.uns.ac.rs.domain.dto.IllnessDto;
import ftn.uns.ac.rs.domain.dto.SymptomDto;
import ftn.uns.ac.rs.domain.entity.*;
import ftn.uns.ac.rs.service.IllnessService;
import ftn.uns.ac.rs.service.KieSessionService;
import ftn.uns.ac.rs.service.SymptomService;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/illness")
public class IllnessController {

    @Autowired
    private IllnessService illnessService;


    @Autowired
    private KieSessionService kieSessionService;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private HashMap<String, KieSession> sessions;

    @Autowired
    private SymptomService symptomService;

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok().body(illnessService.getAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody IllnessDto illness) {
        Illness i = new Illness();
        i.setName(illness.getName());
        Illness newIllness = illnessService.create(i);

        List<IllnessSymptom> illnessSymptomList = new ArrayList<>();

        for (SymptomDto symptomDto : illness.getSymptoms()) {
            // da li je novi
            Symptom symptom = symptomService.getByName(symptomDto.getName());
            if (symptom != null) {
                illnessSymptomList.add(new IllnessSymptom(newIllness, symptom, symptomDto.getSpecific()));
            } else {
                Symptom newSymptom = symptomService.create(new Symptom(symptomDto.getName()));
                illnessSymptomList.add(new IllnessSymptom(newIllness, newSymptom, symptomDto.getSpecific()));
            }
        }
        newIllness.setSymptoms(illnessSymptomList);
        Illness createdIllness = illnessService.create(newIllness);
        kieSessionService.insertIllnessInSessions(createdIllness);
        return ResponseEntity.ok(createdIllness);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        kieSessionService.deleteIllnessFromSessions(id);
        illnessService.delete(id);
        return ResponseEntity.ok("");
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Illness illness) {
        kieSessionService.updateIllnessInSessions(illness);
        return ResponseEntity.ok(illnessService.create(illness));
    }

}
