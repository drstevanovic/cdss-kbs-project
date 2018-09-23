package ftn.uns.ac.rs.service;

import ftn.uns.ac.rs.domain.entity.Symptom;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SymptomService {

    List<Symptom> getAll();
    Symptom getByName(String name);
    Symptom create(Symptom symptom);

}
