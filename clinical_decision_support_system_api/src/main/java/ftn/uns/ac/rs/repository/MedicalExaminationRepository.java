package ftn.uns.ac.rs.repository;

import ftn.uns.ac.rs.domain.entity.MedicalExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, Long>{
}
