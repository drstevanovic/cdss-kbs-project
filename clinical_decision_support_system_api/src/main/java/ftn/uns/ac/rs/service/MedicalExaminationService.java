package ftn.uns.ac.rs.service;

import ftn.uns.ac.rs.domain.entity.MedicalExamination;
import org.springframework.stereotype.Service;

@Service
public interface MedicalExaminationService {

    MedicalExamination create(MedicalExamination medicalExamination);
}
