package com.luv2code.claimedit.utility;

import com.luv2code.claimedit.entity.Claim;

public interface ClaimUtilityHelper {
    public Claim validateUpdateStatus(Claim claim);
    public Claim calculateClaimCharges(Claim claim);
}
