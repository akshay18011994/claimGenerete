package com.luv2code.claimedit.entity;

import java.math.BigDecimal;
import java.util.List;

public class Charge {
    private int chargeId;
    private String procedureCode;
    private List<String> diagnosisCodes;
    private BigDecimal chargeAmount;
    private BigDecimal outstandingAmount;
    private BigDecimal paidAmount;
    private int Claimid;

    public Charge()
    {

    }

    public Charge(int chargeId, String procedureCode, List<String> diagnosisCodes, BigDecimal chargeAmount, BigDecimal outstandingAmount, BigDecimal paidAmount, int claimid) {
        this.chargeId = chargeId;
        this.procedureCode = procedureCode;
        this.diagnosisCodes = diagnosisCodes;
        this.chargeAmount = chargeAmount;
        this.outstandingAmount = outstandingAmount;
        this.paidAmount = paidAmount;
        Claimid = claimid;
    }

    public int getChargeId() {
        return chargeId;
    }

    public void setChargeId(int chargeId) {
        this.chargeId = chargeId;
    }

    public String getProcedureCode() {
        return procedureCode;
    }

    public void setProcedureCode(String procedureCode) {
        this.procedureCode = procedureCode;
    }

    public List<String> getDiagnosisCodes() {
        return diagnosisCodes;
    }

    public void setDiagnosisCodes(List<String> diagnosisCodes) {
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

    public int getClaimid() {
        return Claimid;
    }

    public void setClaimid(int claimid) {
        Claimid = claimid;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "chargeId=" + chargeId +
                ", procedureCode='" + procedureCode + '\'' +
                ", diagnosisCodes=" + diagnosisCodes +
                ", chargeAmount=" + chargeAmount +
                ", outstandingAmount=" + outstandingAmount +
                ", paidAmount=" + paidAmount +
                ", Claimid=" + Claimid +
                '}';
    }
}
