package com.luv2code.claimedit.service;

import com.luv2code.claimedit.entity.Charge;
import com.luv2code.claimedit.entity.Claim;
import com.luv2code.claimedit.entity.Diagnosis;
import com.luv2code.claimedit.entity.PatientDetails;
import com.luv2code.claimedit.repository.ClaimRepository;
import com.luv2code.claimedit.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClaimPatientServiceImpl implements ClaimPatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ClaimRepository claimRepository;

    private List<Claim> claims;

    public ClaimPatientServiceImpl()
    {
       this.claims= populateClaims();
    }

    private List<Claim> populateClaims() {
        List<Claim> claimList = new ArrayList<>();
        Claim claim = new Claim();
        PatientDetails patientDetails = new PatientDetails(222 ,"AA", LocalDate.of(1994,12,1), "MALE");
        List<Diagnosis> listDiagnosis =Arrays.asList(new Diagnosis(1,"S1","fever",111),
                new Diagnosis(2,"S2","cold",222));

        Charge c1 = new Charge(111,"92345", listDiagnosis,new BigDecimal(20),new BigDecimal(20),new BigDecimal(0),91231);
        Charge c2 = new Charge(222,"92345",listDiagnosis,new BigDecimal(20),new BigDecimal(20),new BigDecimal(0),91231);

        List<Charge> listCharges = Arrays.asList(c1,c2);
        claim.setId(9999);
        claim.setPatientDetails(patientDetails);
        claim.setCharges(listCharges);
        claim.setCreated(LocalDate.now());
        claim.setPatientId(222);

        claimList.add(claim);

        return claimList;
    }

    @Override
    @Transactional
    public List<Claim> getPatientClaims(PatientDetails patientDetails) {

        System.out.println("Claims list "+claims.size());
        PatientDetails patientDetails1=patientRepository.getPatientDetailsByIdOrName(patientDetails);
        claims.addAll(patientDetails1.getClaims());
        return claims;
    }

    @Override
    public Claim fetchClaim(int id) {

        if(id ==9999) {
            System.out.println("fetch claim for id - " + id);
            Claim claim = new Claim();
            LocalDate localDate = LocalDate.of(1994, 12, 01);

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String formattedDate = localDate.format(formatter);
            PatientDetails pd = new PatientDetails(222, "AA", LocalDate.of(1994, 12, 1), "MALE");
            List<Diagnosis> listDiagnosis = Arrays.asList(new Diagnosis(1, "S1", "fever", 1),
                    new Diagnosis(2, "S2", "cold", 2));
            Charge c1 = new Charge(1, "92345", listDiagnosis, new BigDecimal(20), new BigDecimal(20), new BigDecimal(0), 91231);
            Charge c2 = new Charge(2, "92345", listDiagnosis, new BigDecimal(20), new BigDecimal(20), new BigDecimal(0), 91231);
            claim.setId(9999);
            List<Charge> listCharges = Arrays.asList(c1, c2);
            claim.setPatientDetails(pd);
            claim.setCharges(listCharges);
            claim.setCreated(LocalDate.now());
            claim.setPatientId(222);
            claim.setStatus("HOLD");
            System.out.println(claim.getPatientDetails().getPatientDOB());
            return claim;
        }
        else {
            return claimRepository.findById(id).get();
        }
    }

    public PatientDetails savePatientDetails(PatientDetails patientDetails)
    {
        return patientRepository.save(patientDetails);
    }

    @Override
    public PatientDetails getPatientDetail(int id) {
        return patientRepository.findById(id).get();
    }

    public Claim saveClaim(Claim claim)
    {
        claim.getCharges().stream().forEach(charge->{charge.setClaim(claim);
        charge.getDiagnosisCodes().stream().forEach(diagnosis -> {diagnosis.setCharge(charge);});});
        return claimRepository.save(claim);
    }

}
