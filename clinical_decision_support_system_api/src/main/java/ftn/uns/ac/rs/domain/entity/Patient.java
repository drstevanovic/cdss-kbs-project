package ftn.uns.ac.rs.domain.entity;

import ftn.uns.ac.rs.util.HeartBeatEvent;
import ftn.uns.ac.rs.util.OxygenEvent;
import ftn.uns.ac.rs.util.UrinationEvent;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "jmbg", nullable = false)
    private String jmbg;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ElementCollection
    private List<String> allergicIngredients = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER)
    private List<MedicalExamination> examinations;

    public Patient(){

    }


    public List<MedicalExamination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<MedicalExamination> examinations) {
        this.examinations = examinations;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getAllergicIngredients() {
        return allergicIngredients;
    }

    public void setAllergicIngredients(List<String> allergicIngredients) {
        this.allergicIngredients = allergicIngredients;
    }

}
