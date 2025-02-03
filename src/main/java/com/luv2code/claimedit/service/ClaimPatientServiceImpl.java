package com.luv2code.claimedit.service;

import com.luv2code.claimedit.entity.Charge;
import com.luv2code.claimedit.entity.Claim;
import com.luv2code.claimedit.entity.PatientDetails;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ClaimPatientServiceImpl implements ClaimPatientService{

    private List<Claim> claims;

    public ClaimPatientServiceImpl()
    {
       this.claims= populateClaims();
    }

    private List<Claim> populateClaims() {
        List<Claim> claimList = new ArrayList<>();
        Claim claim = new Claim();
        PatientDetails patientDetails = new PatientDetails(222 ,"AA", LocalDate.of(1994,12,1), "MALE");
        List<String> listDiagnosis = Arrays.asList("s1","s2");
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
    public List<Claim> getPatientClaims(PatientDetails patientDetails) {

        System.out.println("Claims list "+claims.size());
        return claims;
    }

    @Override
    public Claim fetchClaim(int id) {

        System.out.println("fetch claim for id - " + id);
        Claim claim = new Claim();
        LocalDate localDate =  LocalDate.of(1994,12,01);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = localDate.format(formatter);
        PatientDetails pd = new PatientDetails(222 ,"AA", LocalDate.of(1994,12,1), "MALE");
        List<String> listDiagnosis =Arrays.asList("s1","s2");
        Charge c1 = new Charge(1,"92345", listDiagnosis,new BigDecimal(20),new BigDecimal(20),new BigDecimal(0),91231);
        Charge c2 = new Charge(2,"92345",listDiagnosis,new BigDecimal(20),new BigDecimal(20),new BigDecimal(0),91231);
        claim.setId(9999);
        List<Charge> listCharges = Arrays.asList(c1,c2);
        claim.setPatientDetails(pd);
        claim.setCharges(listCharges);
        claim.setCreated(LocalDate.now());
        claim.setPatientId(222);
        System.out.println(claim.getPatientDetails().getPatientDOB());
        return claim;
    }
}
