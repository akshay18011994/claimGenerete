package com.luv2code.claimedit.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
@Entity
@Table(name = "charge")
public class Charge {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "charge_sequence")
    @SequenceGenerator(initialValue=1111,
            allocationSize=1,
            name = "charge_sequence",
            sequenceName="charge_sequence")
    private int id;
    @Column(name = "procedure_code")
    private String procedureCode;
    @OneToMany(mappedBy = "charge", cascade = CascadeType.ALL)
    private List<Diagnosis> diagnosisCodes;
    @Column(name = "charge_amount")
    private BigDecimal chargeAmount;
    @Column(name = "outstanding_amount")
    private BigDecimal outstandingAmount;
    @Column(name = "paid_amount")
    private BigDecimal paidAmount;
    @Column(name = "claim_id",insertable = false, updatable = false)
    private int claimId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "claim_id")
    private Claim claim;

    public Charge()
    {

    }

    public Charge(int id, String procedureCode, List<Diagnosis> diagnosisCodes, BigDecimal chargeAmount, BigDecimal outstandingAmount, BigDecimal paidAmount, int claimId) {
        this.id = id;
        this.procedureCode = procedureCode;
        this.diagnosisCodes = diagnosisCodes;
        this.chargeAmount = chargeAmount;
        this.outstandingAmount = outstandingAmount;
        this.paidAmount = paidAmount;
        this.claimId = claimId;
    }

    public Charge(String procedureCode, List<Diagnosis> diagnosisCodes, BigDecimal chargeAmount, BigDecimal outstandingAmount, BigDecimal paidAmount) {
        this.procedureCode = procedureCode;
        this.diagnosisCodes = diagnosisCodes;
        this.chargeAmount = chargeAmount;
        this.outstandingAmount = outstandingAmount;
        this.paidAmount = paidAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int chargeId) {
        this.id = id;
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }

    public List<Diagnosis> getDiagnosisCodes() {
        return diagnosisCodes;
    }

    public void setDiagnosisCodes(List<Diagnosis> diagnosisCodes) {
        this.diagnosisCodes = diagnosisCodes;
    }

    public BigDecimal getChargeAmount() {
        return chargeAmount;
    }

    public void setChargeAmount(BigDecimal chargeAmount) {
        this.chargeAmount = chargeAmount;
    }

    public BigDecimal getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(BigDecimal outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(BigDecimal paidAmount) {
        this.paidAmount = paidAmount;
    }

    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    public Claim getClaim() {
        return claim;
    }

    public void setClaim(Claim claim) {
        this.claim = claim;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "id=" + id +
                ", procedureCode='" + procedureCode + '\'' +
                ", diagnosisCodes=" + diagnosisCodes +
                ", chargeAmount=" + chargeAmount +
                ", outstandingAmount=" + outstandingAmount +
                ", paidAmount=" + paidAmount +
                ", claimId=" + claimId +
                '}';
    }
}
