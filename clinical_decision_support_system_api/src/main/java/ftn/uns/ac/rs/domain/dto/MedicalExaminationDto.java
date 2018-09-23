package ftn.uns.ac.rs.domain.dto;

import ftn.uns.ac.rs.domain.entity.Illness;
import ftn.uns.ac.rs.domain.entity.Medicine;
import ftn.uns.ac.rs.domain.entity.User;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class MedicalExaminationDto {


    private Date date;

    private IllnessDto illness;

    private User doctor;

    private List<Medicine> medicines;

    public MedicalExaminationDto(){

    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public IllnessDto getIllness() {
        return illness;
    }

    public void setIllness(IllnessDto illness) {
        this.illness = illness;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }
}
