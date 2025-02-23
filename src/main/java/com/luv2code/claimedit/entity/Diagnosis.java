package com.luv2code.claimedit.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "diagnosis")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diagnosis_sequence")
    @SequenceGenerator(initialValue=100,
            allocationSize=1,
            name = "diagnosis_sequence",
            sequenceName="diagnosis_sequence")
    private int id;
    @Column(name = "diagnosis_code")
    private String diagnosisCode;
    @Column(name = "diagnosis_code_desc")
    private String diagnosisCodeDesc;
    @Column(name = "charge_id",insertable = false, updatable = false)
    private int chargeId;
    @ManyToOne
    @JoinColumn(name = "charge_id")
    private Charge charge;
    @Column(name ="status")
    private String status="A";

    public Diagnosis() {
    }

    public Diagnosis(int id, String diagnosisCode, String diagnosisCodeDesc, int chargeId , String status) {
        this.id = id;
        this.diagnosisCode = diagnosisCode;
        this.diagnosisCodeDesc = diagnosisCodeDesc;
        this.chargeId =chargeId;
        this.status=status;
    }

    public Diagnosis(String diagnosisCode, String diagnosisCodeDesc, String status) {
        this.diagnosisCode = diagnosisCode;
        this.diagnosisCodeDesc = diagnosisCodeDesc;
        this.status=status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiagnosisCode() {
        return diagnosisCode;
    }

    public void setDiagnosisCode(String diagnosisCode) {
        this.diagnosisCode = diagnosisCode;
    }

    public String getDiagnosisCodeDesc() {
        return diagnosisCodeDesc;
    }

    public void setDiagnosisCodeDesc(String diagnosisCodeDesc) {
        this.diagnosisCodeDesc = diagnosisCodeDesc;
    }

    public int getChargeId() {
        return chargeId;
    }

    public void setChargeId(int chargeId) {
        this.chargeId = chargeId;
    }

    public Charge getCharge() {
        return charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Diagnosis{" +
                "id=" + id +
                ", diagnosisCode='" + diagnosisCode + '\'' +
                ", diagnosisCodeDesc='" + diagnosisCodeDesc + '\'' +
                ", chargeId=" + chargeId +
                '}';
    }
}
