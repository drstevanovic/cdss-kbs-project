package ftn.uns.ac.rs.service;

import ftn.uns.ac.rs.domain.entity.MedicalExamination;
import ftn.uns.ac.rs.domain.entity.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PatientService
{
    Patient findById(Long patientId);

    Patient findByJmbg(String jmbg);

    List<Patient> findAll();

    Patient create(Patient patient);

    void delete(Long id);

    Patient addExamination(Patient patient, MedicalExamination examination);
}
