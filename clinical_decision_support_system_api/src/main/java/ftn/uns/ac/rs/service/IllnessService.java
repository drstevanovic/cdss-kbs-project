package ftn.uns.ac.rs.service;

import ftn.uns.ac.rs.domain.entity.Illness;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IllnessService {

    List<Illness> getAll();
    Illness getByName(String name);

    Illness create(Illness illness);

    void delete(Long id);
}
