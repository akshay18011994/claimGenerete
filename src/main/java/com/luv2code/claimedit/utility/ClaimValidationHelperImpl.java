package com.luv2code.claimedit.utility;

import com.luv2code.claimedit.entity.Claim;
import com.luv2code.claimedit.entity.DiagnosisMaster;
import com.luv2code.claimedit.repository.ClaimRepository;
import com.luv2code.claimedit.repository.DiagnosisMasterRepository;
import com.luv2code.claimedit.service.ClaimPatientServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(ClaimValidationHelperImpl.class);


    @Override
    public Claim validateUpdateStatus(Claim claim) {
        try {
            String status = "In-Progress";
            List<Claim> claimList = claimRepository.fetchClaimOlderThanGivenDate(claim, claim.getCreated().minusMonths(6));
            if (null != claimList && !claimList.isEmpty()) {
                List<String> listDiagnosisCodeNewClaim = claim.getCharges().stream().filter(ch -> ch.getStatus().equals("A")).flatMap(c -> c.getDiagnosisCodes().stream().map(d -> d.getDiagnosisCode())).collect(Collectors.toList());
                List<String> listDiagnosisCodeExisting = claimList.stream().flatMap(clm -> clm.getCharges().stream().flatMap(c -> c.getDiagnosisCodes().stream().map(d -> d.getDiagnosisCode()))).collect(Collectors.toList());
                List<String> existDiagnosisCode = listDiagnosisCodeExisting.stream().filter(d -> listDiagnosisCodeNewClaim.contains(d)).collect(Collectors.toList());
                if (null != existDiagnosisCode && !existDiagnosisCode.isEmpty()) {
                    status = "HOLD";
                }
            }
            claim.setStatus(status);
        } catch (Exception e) {
            logger.error("Error in validate Update Status" + e);
        }
        return claim;
    }

    @Transactional
    @Override
    public Claim calculateClaimCharges(Claim claim) {
        try {
            claim.getCharges().stream().filter(chs -> chs.getStatus().equals("A")).forEach(charge -> {
                BigDecimal totalChargeAmount = charge.getDiagnosisCodes().stream()
                        .map(d -> diagnosisMasterRepository.findByDiagnosisCode(d.getDiagnosisCode()).getAmount())
                        .collect(Collectors.reducing(BigDecimal.ZERO, BigDecimal::add));

                charge.setChargeAmount(totalChargeAmount);
                charge.setOutstandingAmount(totalChargeAmount);
                charge.setPaidAmount(BigDecimal.ZERO);
            });
        } catch (Exception e) {
            logger.error("Error in calculate Claim Charges" + e);
        }
        return claim;
    }

    @Transactional
    @Override
    public DiagnosisMaster fetchDiagnosisCodeDesc(String code) {
        DiagnosisMaster diagnosisMaster=null;
        try {
            diagnosisMaster= diagnosisMasterRepository.findByDiagnosisCode(code);
        } catch (Exception e) {
            logger.error("Error in fetch Diagnosis Code Desc" + e);
        }
        return diagnosisMaster;
    }
}
