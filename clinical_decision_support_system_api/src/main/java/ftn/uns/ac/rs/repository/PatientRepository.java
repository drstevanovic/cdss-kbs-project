package ftn.uns.ac.rs.repository;

import ftn.uns.ac.rs.domain.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Long>{

    Patient findByJmbg(String jmgg);
}
