package ftn.uns.ac.rs.service.serviceImpl;

import ftn.uns.ac.rs.domain.entity.MedicalExamination;
import ftn.uns.ac.rs.exeptions.MySavingInRepoException;
import ftn.uns.ac.rs.repository.MedicalExaminationRepository;
import ftn.uns.ac.rs.service.MedicalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MedicalExaminationServiceImpl implements MedicalExaminationService {

    @Autowired
    private MedicalExaminationRepository medicalExaminationRepository;

    @Override
    public MedicalExamination create(MedicalExamination medicalExamination) {
        return Optional.ofNullable(medicalExaminationRepository.save(medicalExamination))
                .orElseThrow(() -> new MySavingInRepoException("Problem with saving examination"));
    }
}
