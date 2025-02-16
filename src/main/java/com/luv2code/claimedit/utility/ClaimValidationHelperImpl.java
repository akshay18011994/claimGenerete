package com.luv2code.claimedit.utility;

import com.luv2code.claimedit.entity.Claim;
import org.springframework.stereotype.Component;

@Component
public class ClaimValidationHelperImpl implements ClaimUtilityHelper {
    @Override
    public Claim validateUpdateStatus(Claim claim) {
        return null;
    }

    @Override
    public Claim calculateClaimCharges(Claim claim) {
        return null;
    }
}
