package com.luv2code.claimedit.entity;

import java.time.LocalDate;

public class PatientDetails {
    private String patientName;
    private LocalDate patientDOB;
    private String patientId;

    public PatientDetails()
    {

    }

    public PatientDetails(String patientName, LocalDate patientDOB, String patientId) {
        this.patientName = patientName;
        this.patientDOB = patientDOB;
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDate getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(LocalDate patientDOB) {
        this.patientDOB = patientDOB;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
