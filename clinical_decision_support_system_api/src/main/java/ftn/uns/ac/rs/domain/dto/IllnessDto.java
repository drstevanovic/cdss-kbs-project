package ftn.uns.ac.rs.domain.dto;

import ftn.uns.ac.rs.domain.entity.Symptom;

import javax.persistence.*;
import java.util.List;


public class IllnessDto {

    private String name;

    private List<SymptomDto> symptoms;

    public IllnessDto(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SymptomDto> getSymptoms(){
        return symptoms;
    }

    public void setSymptoms(List<SymptomDto> symptoms) {
        this.symptoms = symptoms;
    }
}
