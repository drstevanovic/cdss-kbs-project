package ftn.uns.ac.rs.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class IllnessSymptom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "illness_id")
    private Illness illness;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "symptom_id")
    private Symptom symptom;

    @Column(name = "ordinary")
    private boolean ordinary;

    public IllnessSymptom(){}

    public IllnessSymptom(Illness illness, Symptom symptom, boolean ordinary) {
        this.illness = illness;
        this.symptom = symptom;
        this.ordinary = ordinary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Illness getIllness() {
        return illness;
    }

    public void setIllness(Illness illness) {
        this.illness = illness;
    }

    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }

    public boolean isOrdinary() {
        return ordinary;
    }

    public void setOrdinary(boolean ordinary) {
        this.ordinary = ordinary;
    }
}
