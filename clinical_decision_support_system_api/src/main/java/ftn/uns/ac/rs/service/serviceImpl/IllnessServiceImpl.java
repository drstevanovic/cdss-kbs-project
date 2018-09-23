package ftn.uns.ac.rs.service.serviceImpl;

import ftn.uns.ac.rs.domain.entity.Illness;
import ftn.uns.ac.rs.exeptions.MyAlreadyExistsException;
import ftn.uns.ac.rs.exeptions.MySavingInRepoException;
import ftn.uns.ac.rs.repository.IllnessRepository;
import ftn.uns.ac.rs.service.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IllnessServiceImpl implements IllnessService {


    @Autowired
    private IllnessRepository illnessRepository;

    @Override
    public List<Illness> getAll() {
        return illnessRepository.findAll();
    }

    @Override
    public Illness getByName(String name) {
        return illnessRepository.findByName(name);
    }

    @Override
    public Illness create(Illness illness) {
//        if (this.getByName(illness.getName()) != null && illness.getId()==null) {
//            throw new MyAlreadyExistsException("Illness with the given name already exists! " + illness.getName());
//        }

        return Optional.ofNullable(illnessRepository.save(illness))
                .orElseThrow(() -> new MySavingInRepoException("Problem with saving illness"));
    }

    @Override
    public void delete(Long id) {
        illnessRepository.deleteById(id);
    }
}
