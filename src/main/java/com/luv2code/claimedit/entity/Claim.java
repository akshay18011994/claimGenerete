package com.luv2code.claimedit.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "claim")

public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "claim_sequence")
    @SequenceGenerator(initialValue=9000,
            allocationSize=1,
            name = "claim_sequence",
            sequenceName="claim_sequence")
    private int id;
    @Column(name = "primary_insurance")
    private String primaryInsurance;
    @Column(name = "secondary_insurance")
    private String secondaryInsurance;

    @OneToMany(mappedBy = "claim", cascade = CascadeType.ALL)
    private List<Charge> charges;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private PatientDetails patientDetails;
    @Column(name = "created")
    private LocalDate created;
    @Column(name = "patient_id",insertable = false, updatable = false)
    private int patientId;
    @Column(name = "status")
    private String status ="New";


    public Claim()
    {
        this.charges = new ArrayList<>();
        addOneCharge();
    }


    public Claim(int id, String primaryInsurance, String secondaryInsurance, List<Charge> charges, PatientDetails patientDetails , LocalDate created , int patientId, String status) {
        this.id = id;
        this.primaryInsurance = primaryInsurance;
        this.secondaryInsurance = secondaryInsurance;
        this.charges = charges;
        this.patientDetails = patientDetails;
        this.created = created;
        this.patientId = patientId;
        this.status=status;
    }

    public Claim(String primaryInsurance, String secondaryInsurance, List<Charge> charges, LocalDate created, String status, PatientDetails patientDetails) {
        this.primaryInsurance = primaryInsurance;
        this.secondaryInsurance = secondaryInsurance;
        this.charges = charges;
        this.created = created;
        this.status = status;
        this.patientDetails = patientDetails;
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
        System.out.println("inside setter of charges");
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private void addOneCharge() {
        if(null != this  && this.charges.isEmpty())
        {
            charges.add(new Charge());
        }
    }
}
