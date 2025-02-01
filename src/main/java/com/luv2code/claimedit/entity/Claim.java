package com.luv2code.claimedit.entity;

import java.util.List;

public class Claim {

    private int claimId;
    private String primaryInsurance;
    private String secondaryInsurance;
    private List<Charge> charges;
    private PatientDetails patientDetails;

    public Claim()
    {

    }

    public Claim(int claimId, String primaryInsurance, String secondaryInsurance, List<Charge> charges, PatientDetails patientDetails) {
        this.claimId = claimId;
        this.primaryInsurance = primaryInsurance;
        this.secondaryInsurance = secondaryInsurance;
        this.charges = charges;
        this.patientDetails = patientDetails;
    }

    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
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
}
