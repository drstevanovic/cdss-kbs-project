package ftn.uns.ac.rs.controller;

import ftn.uns.ac.rs.domain.entity.Medicine;
import ftn.uns.ac.rs.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/medicine")
public class MedicineController {

    @Autowired
    private MedicineService medicineService;

    @GetMapping()
    public ResponseEntity<?> getAllMedicines() {
        return ResponseEntity.accepted().body(medicineService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Medicine medicine) {
        return ResponseEntity.ok(medicineService.create(medicine));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        medicineService.delete(id);
        return ResponseEntity.ok("");
    }
}
