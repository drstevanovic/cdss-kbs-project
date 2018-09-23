package ftn.uns.ac.rs.domain.entity;

import ftn.uns.ac.rs.domain.enums.MedicineType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @ElementCollection
    private List<String> ingredients;

    @Enumerated(EnumType.STRING)
    @Column
    private MedicineType medicineType;

    public Medicine(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public MedicineType getMedicineType() {
        return medicineType;
    }

    public void setMedicineType(MedicineType medicineType) {
        this.medicineType = medicineType;
    }
}
