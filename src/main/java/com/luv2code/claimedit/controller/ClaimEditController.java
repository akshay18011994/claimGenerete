package com.luv2code.claimedit.controller;

import com.luv2code.claimedit.entity.Charge;
import com.luv2code.claimedit.entity.Claim;
import com.luv2code.claimedit.entity.Diagnosis;
import com.luv2code.claimedit.entity.PatientDetails;
import com.luv2code.claimedit.service.ClaimPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class ClaimEditController {

    @Autowired
    ClaimPatientService claimPatientService;

    @RequestMapping("/")
    public String populateClaims(Model model)
    {
        Claim claim = new Claim();
        LocalDate localDate =  LocalDate.of(1994,12,01);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = localDate.format(formatter);
        PatientDetails pd = new PatientDetails(222 ,"AA", LocalDate.of(1994,12,1), "MALE");
        List<Diagnosis> listDiagnosis =Arrays.asList(new Diagnosis(1,"S1","fever",1),
        new Diagnosis(2,"S2","cold",2 ));

        Charge c1 = new Charge(1,"92345", listDiagnosis,new BigDecimal(20),new BigDecimal(20),new BigDecimal(0),91231);
        Charge c2 = new Charge(2,"92345",listDiagnosis,new BigDecimal(20),new BigDecimal(20),new BigDecimal(0),91231);

        List<Charge> listCharges = Arrays.asList(c1,c2);
        claim.setPatientDetails(pd);
        claim.setCharges(listCharges);
        claim.setCreated(LocalDate.now());
        claim.setPatientId(222);
        System.out.println(claim.getPatientDetails().getPatientDOB());
        model.addAttribute("claim" , claim);
        model.addAttribute("formattedDate" , formattedDate);

        return "populateClaim";
    }

    @PostMapping("/processClaim")
    public String processClaim(@ModelAttribute Claim claim)
    {
        System.out.println(claim.getCharges().size());
        claim.getCharges().stream().forEach(charge -> {charge.setClaim(claim);});

        PatientDetails patientDetails = claimPatientService.getPatientDetail(claim.getPatientDetails().getId());
        claim.setPatientDetails(patientDetails);
        claimPatientService.saveClaim(claim);
        return "populateClaim";
    }

    @RequestMapping("/claimEdit")
    public String populateSearchedClaim(@RequestParam("claimId") int claimId , Model model)
    {

        Claim claim=claimPatientService.fetchClaim(claimId);

        claim.getCharges().forEach(System.out::println);
        System.out.println("------------------------");

        model.addAttribute("claim" , claim);

        return "populateClaim";
    }

    @RequestMapping("/newClaim")
    public String newClaimGeneration(@RequestParam("patientId") int patientId ,Model model)
    {
        PatientDetails patientDetails = claimPatientService.getPatientDetail(patientId);
        Claim claim = new Claim();
        claim.setPatientDetails(patientDetails);
        model.addAttribute("claim" , claim);
        return "populateClaim";
    }
}
