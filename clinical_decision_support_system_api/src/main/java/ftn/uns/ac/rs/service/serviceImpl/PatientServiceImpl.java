package ftn.uns.ac.rs.service.serviceImpl;

import ftn.uns.ac.rs.domain.entity.MedicalExamination;
import ftn.uns.ac.rs.domain.entity.Patient;
import ftn.uns.ac.rs.exeptions.MyAlreadyExistsException;
import ftn.uns.ac.rs.exeptions.MyNotFoundExeption;
import ftn.uns.ac.rs.exeptions.MySavingInRepoException;
import ftn.uns.ac.rs.repository.PatientRepository;
import ftn.uns.ac.rs.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient findById(Long patientId) {
        return patientRepository.getOne(patientId);
    }

    @Override
    public Patient findByJmbg(String jmbg) {
        Patient p = patientRepository.findByJmbg(jmbg);
        if (patientRepository.findByJmbg(jmbg) == null) {
            throw new MyNotFoundExeption("Patient with jmbg: " + jmbg + " does not exist.");
        }
        return p;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient create(Patient patient) {
//        if (patientRepository.findByJmbg(patient.getJmbg()) != null) {
//            throw new MyAlreadyExistsException("Already exist patient with jmbg: " + patient.getJmbg());
//        }

        return Optional.ofNullable(patientRepository.save(patient))
                .orElseThrow(() -> new MySavingInRepoException("Problem with saving patient"));
    }

    @Override
    public void delete(Long id) {
        Optional.ofNullable(patientRepository.getOne(id))
                .orElseThrow(() -> new MyNotFoundExeption("Can not delete patient which does not exits."));

        patientRepository.deleteById(id);
    }

    @Override
    public Patient addExamination(Patient patient, MedicalExamination examination) {
        patient.getExaminations().add(examination);
        return this.patientRepository.save(patient);
    }
}
