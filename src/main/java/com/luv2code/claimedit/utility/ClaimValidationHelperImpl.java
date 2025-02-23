package com.luv2code.claimedit.utility;

import com.luv2code.claimedit.entity.Claim;
import com.luv2code.claimedit.entity.DiagnosisMaster;
import com.luv2code.claimedit.repository.ClaimRepository;
import com.luv2code.claimedit.repository.DiagnosisMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClaimValidationHelperImpl implements ClaimUtilityHelper {

    @Autowired
    DiagnosisMasterRepository diagnosisMasterRepository;

    @Autowired
    ClaimRepository claimRepository;

    @Override
    public Claim validateUpdateStatus(Claim claim) {
        String status="In-Progress";
        List<Claim> claimList =claimRepository.fetchClaimOlderThanGivenDate(claim,claim.getCreated().minusMonths(6));
        if(null !=claimList && !claimList.isEmpty())
        {
            List<String> listDiagnosisCodeNewClaim = claim.getCharges().stream().filter(ch->ch.getStatus().equals("A")).flatMap(c->c.getDiagnosisCodes().stream().map(d->d.getDiagnosisCode())).collect(Collectors.toList());
            List<String> listDiagnosisCodeExisting = claimList.stream().flatMap(clm -> clm.getCharges().stream().flatMap(c->c.getDiagnosisCodes().stream().map(d->d.getDiagnosisCode()))).collect(Collectors.toList());
            List<String> existDiagnosisCode =listDiagnosisCodeNewClaim.stream().filter(d->listDiagnosisCodeNewClaim.contains(d)).collect(Collectors.toList());
            if(null !=existDiagnosisCode && !existDiagnosisCode.isEmpty())
            {
                status="HOLD";
            }
        }
        claim.setStatus(status);
        return claim;
    }

    @Transactional
    @Override
    public Claim calculateClaimCharges(Claim claim) {
        claim.getCharges().stream().filter(chs->chs.getStatus().equals("A")).forEach(charge -> {
            BigDecimal totalChargeAmount = charge.getDiagnosisCodes().stream()
                    .map(d -> diagnosisMasterRepository.findByDiagnosisCode(d.getDiagnosisCode()).getAmount())
                    .collect(Collectors.reducing(BigDecimal.ZERO, BigDecimal::add));

            charge.setChargeAmount(totalChargeAmount);
        });
        return claim;
    }

    @Transactional
    @Override
    public DiagnosisMaster fetchDiagnosisCodeDesc(String code) {
        return diagnosisMasterRepository.findByDiagnosisCode(code);
    }
}
