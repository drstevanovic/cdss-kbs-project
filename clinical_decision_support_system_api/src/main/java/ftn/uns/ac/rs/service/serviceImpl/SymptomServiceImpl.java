package ftn.uns.ac.rs.service.serviceImpl;

import ftn.uns.ac.rs.domain.entity.Symptom;
import ftn.uns.ac.rs.repository.SymptomRepository;
import ftn.uns.ac.rs.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;
import java.util.List;

@Service
public class SymptomServiceImpl implements SymptomService {

    @Autowired
    private SymptomRepository symptomRepository;

    @Override
    public List<Symptom> getAll() {
        return symptomRepository.findAll();
    }

    @Override
    public Symptom getByName(String name) {
        return symptomRepository.findByName(name);
    }

    @Override
    public Symptom create(Symptom symptom) {
        return symptomRepository.save(symptom);
    }
}
