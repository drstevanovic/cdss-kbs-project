package ftn.uns.ac.rs.domain.dto;

import ftn.uns.ac.rs.domain.entity.Patient;

import java.util.Date;
import java.util.List;

public class PatientsSymptoms {

    private List<String> symptoms;
    private Patient patient;
    private Date currentDate;
    public PatientsSymptoms(){}

    public PatientsSymptoms(List<String> symptoms, Patient patientId) {
        this.symptoms = symptoms;
        this.patient = patientId;
    }


    public List<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}
