package com.luv2code.claimedit.utility;

import com.luv2code.claimedit.entity.Claim;
import com.luv2code.claimedit.entity.DiagnosisMaster;

public interface ClaimUtilityHelper {
    public Claim validateUpdateStatus(Claim claim);
    public Claim calculateClaimCharges(Claim claim);
    public DiagnosisMaster fetchDiagnosisCodeDesc(String code);
}
