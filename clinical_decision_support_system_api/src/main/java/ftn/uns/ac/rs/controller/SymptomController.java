package ftn.uns.ac.rs.controller;

import ftn.uns.ac.rs.domain.dto.SymptomDto;
import ftn.uns.ac.rs.domain.entity.Symptom;
import ftn.uns.ac.rs.service.PatientService;
import ftn.uns.ac.rs.service.SymptomService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/symptoms")
public class SymptomController {

    @Autowired
    private SymptomService symptomService;

    private ModelMapper mapper = new ModelMapper();

    @GetMapping()
    public ResponseEntity<?> getAllSymptoms() {
        List<Symptom> symptomList = symptomService.getAll();
        List<SymptomDto> symptomDtos = new ArrayList<>();
        for(Symptom symptom: symptomList){
            symptomDtos.add(mapper.map(symptom, SymptomDto.class));
        }

        return ResponseEntity.ok(symptomDtos);
    }

}
