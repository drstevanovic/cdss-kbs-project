package ftn.uns.ac.rs.domain.entity;

import javax.persistence.*;
import java.util.List;


@Entity
public class Illness {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "illness", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<IllnessSymptom> symptoms;

    public Illness(){

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

    public List<IllnessSymptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<IllnessSymptom> symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public String toString() {
        return "Illness{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symptoms=" + symptoms +
                '}';
    }
}
