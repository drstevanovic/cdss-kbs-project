package ftn.uns.ac.rs.service.serviceImpl;

import ftn.uns.ac.rs.domain.entity.Medicine;
import ftn.uns.ac.rs.domain.entity.Patient;
import ftn.uns.ac.rs.exeptions.MyAlreadyExistsException;
import ftn.uns.ac.rs.exeptions.MyNotFoundExeption;
import ftn.uns.ac.rs.exeptions.MySavingInRepoException;
import ftn.uns.ac.rs.repository.MedicineRepository;
import ftn.uns.ac.rs.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineRepository medicineRepository;

    @Override
    public List<Medicine> findAll() {
        return medicineRepository.findAll();
    }

    @Override
    public Medicine create(Medicine medicine) {
        if (medicineRepository.findByName(medicine.getName()) != null) {
            throw new MyAlreadyExistsException("Already exist medicine with name: !" + medicine.getName());
        }

        return Optional.ofNullable(medicineRepository.save(medicine))
                .orElseThrow(() -> new MySavingInRepoException("Problem with saving medicine"));
    }

    @Override
    public void delete(Long id) {
        Optional.ofNullable(medicineRepository.getOne(id))
                .orElseThrow(() -> new MyNotFoundExeption("Can not delete medicine which does not exits."));

        medicineRepository.deleteById(id);
    }
}
