package ftn.uns.ac.rs.service;

import ftn.uns.ac.rs.domain.entity.Medicine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedicineService {


    List<Medicine> findAll();

    Medicine create(Medicine medicine);

    void delete(Long id);
}
