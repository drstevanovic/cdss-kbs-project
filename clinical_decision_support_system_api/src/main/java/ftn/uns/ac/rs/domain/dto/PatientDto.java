package ftn.uns.ac.rs.domain.dto;

import ftn.uns.ac.rs.domain.entity.MedicalExamination;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

public class PatientDto {


    private String jmbg;

    private String firstName;

    private String lastName;

    private List<String> allergicIngredients;


    private List<MedicalExamination> examinations;

    public PatientDto(){

    }


    public List<MedicalExamination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<MedicalExamination> examinations) {
        this.examinations = examinations;
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
