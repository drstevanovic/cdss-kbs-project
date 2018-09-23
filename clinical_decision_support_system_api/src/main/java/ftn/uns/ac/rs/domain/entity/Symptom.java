package ftn.uns.ac.rs.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Symptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;


    @OneToMany(mappedBy = "symptom", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<IllnessSymptom> illness;

    public Symptom(){

    }

    public Symptom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<IllnessSymptom> getIllness() {
        return illness;
    }

    public void setIllness(List<IllnessSymptom> illness) {
        this.illness = illness;
    }
}
