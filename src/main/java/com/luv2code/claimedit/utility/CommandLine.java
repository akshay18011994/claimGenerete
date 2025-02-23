package com.luv2code.claimedit.utility;

import com.luv2code.claimedit.entity.*;
import com.luv2code.claimedit.repository.ClaimRepository;
import com.luv2code.claimedit.repository.DiagnosisMasterRepository;
import jakarta.persistence.EntityManager;
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
    EntityManager entityManager;

    @Autowired
    DiagnosisMasterRepository diagnosisMasterRepository;
    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Claim claim = new Claim();
        LocalDate localDate =  LocalDate.of(1994,12,01);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = localDate.format(formatter);
        PatientDetails pd = new PatientDetails("AA", LocalDate.of(1994,12,1), "MALE","shastri Nagar","Maharashtra","Pune","410210",91,"9870490686","a@b.com","ICICI LOMBARD","INS6543","Sun Light Issue","Back Injury","Rohit Sharma","9875834573");
        List<Diagnosis> listDiagnosis = Arrays.asList(new Diagnosis("S1","fever","A"),
                new Diagnosis("S2","cold","A"));
        List<Diagnosis> listDiagnosis2 = Arrays.asList(new Diagnosis("S1","fever","A"),
                new Diagnosis("S2","cold","A"));
        List<Diagnosis> listDiagnosis3 = Arrays.asList(new Diagnosis("S1","fever","A"),
                new Diagnosis("S2","cold","A"));
        Charge c1 = new Charge("92345", listDiagnosis,new BigDecimal(20),new BigDecimal(20),new BigDecimal(0),"A");
        Charge c2 = new Charge("92345",listDiagnosis3,new BigDecimal(20),new BigDecimal(20),new BigDecimal(0),"A");
        Charge c3 = new Charge("92345",listDiagnosis2,new BigDecimal(20),new BigDecimal(20),new BigDecimal(0),"D");

        List<Charge> listCharges = Arrays.asList(c1,c2,c3);
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
        System.out.println("line 1 : "+claim.hashCode());
        entityManager.merge(claim);


        DiagnosisMaster dm1 = new DiagnosisMaster("s1","fever",new BigDecimal("123.5"));
        DiagnosisMaster dm2 = new DiagnosisMaster("s2","Knee Pain",new BigDecimal("200.50"));
        DiagnosisMaster dm3 = new DiagnosisMaster("s3","Heart Issue",new BigDecimal("1000"));



        diagnosisMasterRepository.saveAll(Arrays.asList(dm1,dm2,dm3));



    }
}
