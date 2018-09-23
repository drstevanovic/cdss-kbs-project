package ftn.uns.ac.rs.repository;

import ftn.uns.ac.rs.domain.entity.Illness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IllnessRepository extends JpaRepository<Illness,Long> {
    Illness findByName(String name);
}
