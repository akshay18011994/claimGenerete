package com.luv2code.claimedit.utility;

import com.luv2code.claimedit.entity.Charge;
import com.luv2code.claimedit.entity.Claim;
import com.luv2code.claimedit.entity.Diagnosis;
import com.luv2code.claimedit.entity.PatientDetails;
import com.luv2code.claimedit.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

@Component
public class CommandLine implements CommandLineRunner {

    @Autowired
    ClaimRepository claimRepository;
    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Claim claim = new Claim();
        LocalDate localDate =  LocalDate.of(1994,12,01);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = localDate.format(formatter);
        PatientDetails pd = new PatientDetails("AA", LocalDate.of(1994,12,1), "MALE","shastri Nagar","Maharashtra","Pune","410210",91,"9870490686","a@b.com","ICICI LOMBARD","INS6543","Sun Light Issue","Back Injury","Rohit Sharma","9875834573");
        List<Diagnosis> listDiagnosis = Arrays.asList(new Diagnosis("S1","fever"),
                new Diagnosis("S2","cold"));
        List<Diagnosis> listDiagnosis2 = Arrays.asList(new Diagnosis("S1","fever"),
                new Diagnosis("S2","cold"));
        Charge c1 = new Charge("92345", listDiagnosis,new BigDecimal(20),new BigDecimal(20),new BigDecimal(0));
        Charge c2 = new Charge("92345",listDiagnosis2,new BigDecimal(20),new BigDecimal(20),new BigDecimal(0));

        List<Charge> listCharges = Arrays.asList(c1,c2);
        claim.setPatientDetails(pd);
        claim.setCharges(listCharges);
        claim.setCreated(LocalDate.now());
        claim.setStatus("HOLD");
        claim.setPrimaryInsurance(pd.getInsuranceProviderName());
        claim.setSecondaryInsurance(pd.getInsuranceProviderName());

        claim.getCharges().stream().forEach(charge->
            {
                charge.setClaim(claim);
                charge.getDiagnosisCodes().stream().forEach(diagnosis -> {diagnosis.setCharge(charge);});
            });
        claimRepository.save(claim);

    }
}
