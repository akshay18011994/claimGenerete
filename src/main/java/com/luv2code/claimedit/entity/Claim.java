package com.luv2code.claimedit.entity;

import java.time.LocalDate;
import java.util.List;

public class Claim {

    private int id;
    private String primaryInsurance;
    private String secondaryInsurance;
    private List<Charge> charges;
    private PatientDetails patientDetails;
    private LocalDate created;
    private int patientId;

    public Claim()
    {

    }

    public Claim(int id, String primaryInsurance, String secondaryInsurance, List<Charge> charges, PatientDetails patientDetails , LocalDate created , int patientId) {
        this.id = id;
        this.primaryInsurance = primaryInsurance;
        this.secondaryInsurance = secondaryInsurance;
        this.charges = charges;
        this.patientDetails = patientDetails;
        this.created = created;
        this.patientId = patientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimaryInsurance() {
        return primaryInsurance;
    }

    public void setPrimaryInsurance(String primaryInsurance) {
        this.primaryInsurance = primaryInsurance;
    }

    public String getSecondaryInsurance() {
        return secondaryInsurance;
    }

    public void setSecondaryInsurance(String secondaryInsurance) {
        this.secondaryInsurance = secondaryInsurance;
    }

    public List<Charge> getCharges() {
        return charges;
    }

    public void setCharges(List<Charge> charges) {
        this.charges = charges;
    }

    public PatientDetails getPatientDetails() {
        return patientDetails;
    }

    public void setPatientDetails(PatientDetails patientDetails) {
        this.patientDetails = patientDetails;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
}
