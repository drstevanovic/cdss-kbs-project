package ftn.uns.ac.rs.controller;

import ftn.uns.ac.rs.domain.dto.MedicalExaminationDto;
import ftn.uns.ac.rs.domain.dto.ResponseDto;
import ftn.uns.ac.rs.domain.entity.Illness;
import ftn.uns.ac.rs.domain.entity.MedicalExamination;
import ftn.uns.ac.rs.domain.entity.Medicine;
import ftn.uns.ac.rs.domain.entity.Patient;
import ftn.uns.ac.rs.service.IllnessService;
import ftn.uns.ac.rs.service.KieSessionService;
import ftn.uns.ac.rs.service.MedicalExaminationService;
import ftn.uns.ac.rs.service.PatientService;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping(value = "/api/examinations")
public class MedicalExaminationController {

    @Autowired
    private HashMap<String, KieSession> sessions;

    @Autowired
    private PatientService patientService;

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private MedicalExaminationService medicalExaminationService;

    @Autowired
    private IllnessService illnessService;

    @Autowired
    private KieSessionService kieSessionService;

    private ModelMapper mapper = new ModelMapper();

    @PostMapping(value = "/validate-patient/{jmbg}")
    public ResponseEntity<?> validate(@RequestBody List<Medicine> medicines, @PathVariable String jmbg) {
        Patient patient = patientService.findByJmbg(jmbg);
        String currentUser = (String)servletContext.getAttribute("currentUser");

        KieSession session = sessions.get(currentUser);
        session.fireAllRules();

        HashMap<String, Set<String>> ingredients = new HashMap<>();
        List<ResponseDto> responseDtos = new ArrayList<>();
        for (Medicine m : medicines) {
            HashSet<String> listMedicineIngredients = new HashSet<>();
            QueryResults results = session.getQueryResults("checkIfAllergic", m, patient.getAllergicIngredients());
            for (QueryResultsRow result : results) {
                for (String ingredient : (List<String>) result.get("foundIngredients")) {
                    listMedicineIngredients.add(ingredient);
                }
                ingredients.put(m.getName(), listMedicineIngredients);
            }
        }
        for (Map.Entry<String, Set<String>> i : ingredients.entrySet()) {
            if (i.getValue().size() > 0)
                responseDtos.add(new ResponseDto(i.getKey(), i.getValue()));
        }
        return ResponseEntity.ok(responseDtos);
    }

    @PostMapping("/{jmbg}")
    public ResponseEntity<?> create(@RequestBody MedicalExaminationDto examinationDto, @PathVariable String jmbg) {
        Patient patient = this.patientService.findByJmbg(jmbg);
        Illness illness = illnessService.getByName(examinationDto.getIllness().getName());
        MedicalExamination medicalExamination = new MedicalExamination();
        medicalExamination.setDate(new Date());
        medicalExamination.setDoctor(examinationDto.getDoctor());
        medicalExamination.setIllness(illness);
        medicalExamination.setMedicines(examinationDto.getMedicines());
        MedicalExamination examination = medicalExaminationService.create(medicalExamination);
        patient = this.patientService.addExamination(patient, examination);

        this.kieSessionService.updatePatientInSessions(patient);
        return ResponseEntity.ok(examination);
    }

}
