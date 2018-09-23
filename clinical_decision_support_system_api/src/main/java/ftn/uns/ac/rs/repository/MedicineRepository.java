package ftn.uns.ac.rs.repository;

import ftn.uns.ac.rs.domain.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Long>{
    Medicine findByName(String name);
}
