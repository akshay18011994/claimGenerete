package com.luv2code.claimedit.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class PatientDetails {
    private String patientName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate patientDOB;
    private int id;
    private String gender;

    public PatientDetails()
    {

    }

    public PatientDetails(int id , String patientName, LocalDate patientDOB , String gender) {
        this.patientName = patientName;
        this.patientDOB = patientDOB;
        this.id = id;
        this.gender=gender;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "PatientDetails{" +
                "patientName='" + patientName + '\'' +
                ", patientDOB=" + patientDOB +
                ", patientId='" + id + '\'' +
                '}';
    }
}
