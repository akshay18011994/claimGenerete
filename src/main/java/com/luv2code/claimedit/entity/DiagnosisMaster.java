package com.luv2code.claimedit.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name ="diagnosis_master")
public class DiagnosisMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "diagnosis_code")
    private String diagnosisCode;
    @Column(name = "diagnosis_code_desc")
    private String diagnosisCodeDesc;
    @Column(name = "amount")
    private BigDecimal amount;

    public DiagnosisMaster() {
    }

    public DiagnosisMaster(String diagnosisCode, String diagnosisCodeDesc, BigDecimal amount) {
        this.diagnosisCode = diagnosisCode;
        this.diagnosisCodeDesc = diagnosisCodeDesc;
        this.amount = amount;
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "DiagnosisMaster{" +
                "id=" + id +
                ", diagnosisCode='" + diagnosisCode + '\'' +
                ", diagnosisCodeDesc='" + diagnosisCodeDesc + '\'' +
                ", amount=" + amount +
                '}';
    }
}

