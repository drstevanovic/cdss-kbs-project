package ftn.uns.ac.rs.controller;

import ftn.uns.ac.rs.domain.dto.PatientDto;
import ftn.uns.ac.rs.domain.entity.Patient;
import ftn.uns.ac.rs.service.KieSessionService;
import ftn.uns.ac.rs.service.PatientService;
import org.kie.api.runtime.KieSession;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private KieSessionService kieSessionService;

    @Autowired
    private HashMap<String, KieSession> sessions;

    private ModelMapper mapper = new ModelMapper();

    @GetMapping()
    public ResponseEntity<?> getAllPatients() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping("/{jmbg}")
    public ResponseEntity<?> getPatientByJmbg(@PathVariable String jmbg) {
        return ResponseEntity.ok(patientService.findByJmbg(jmbg));
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody PatientDto patientDto) {
        Patient patient = mapper.map(patientDto, Patient.class);
        Patient newPatient = patientService.create(patient);
        kieSessionService.insertPatientInSessions(newPatient);
        return ResponseEntity.accepted().body(mapper.map(newPatient, PatientDto.class));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Patient patientDto) {
        Patient patient = mapper.map(patientDto, Patient.class);
        kieSessionService.updatePatientInSessions(patient);
        return ResponseEntity.ok(mapper.map(patientService.create(patient), PatientDto.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        kieSessionService.deletePatientFromSessions(id);
        patientService.delete(id);
        return ResponseEntity.ok("");
    }
}
