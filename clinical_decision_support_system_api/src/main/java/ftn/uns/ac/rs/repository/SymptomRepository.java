package ftn.uns.ac.rs.repository;

import ftn.uns.ac.rs.domain.entity.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomRepository  extends JpaRepository<Symptom,Long>{
    Symptom findByName(String neme);
}
