package com.luv2code.claimedit.controller;

import com.luv2code.claimedit.entity.Charge;
import com.luv2code.claimedit.entity.Claim;
import com.luv2code.claimedit.entity.Diagnosis;
import com.luv2code.claimedit.entity.PatientDetails;
import com.luv2code.claimedit.service.ClaimPatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        List<Diagnosis> listDiagnosis =Arrays.asList(new Diagnosis(1,"S1","fever",1,"A"),
        new Diagnosis(2,"S2","cold",2,"A"));

        Charge c1 = new Charge(1,"92345", listDiagnosis,new BigDecimal(20),new BigDecimal(20),new BigDecimal(0),91231,"A");
        Charge c2 = new Charge(2,"92345",listDiagnosis,new BigDecimal(20),new BigDecimal(20),new BigDecimal(0),91231,"A");

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
    public String processClaim(@ModelAttribute("claim") @Valid Claim claim,BindingResult bindingResult, Model model, @RequestParam(required = false) String removedCharges)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("claim",claim);
            return  "populateClaim";
        }
        System.out.println("-------processClaim ------------");

        System.out.println(claim.getCharges().size());

        PatientDetails patientDetails = claimPatientService.getPatientDetail(claim.getPatientDetails().getId());
        claim.setPatientId(patientDetails.getId());
        claim.setPatientDetails(patientDetails);
        claim=claimPatientService.saveClaim(claim);
         Claim fetchedClaim=claimPatientService.fetchClaim(claim.getId());
        model.addAttribute("claim",fetchedClaim);
        System.out.println("-------processClaim END ------------");
        return "populateClaim";
    }

    @RequestMapping("/claimEdit")
    public String populateSearchedClaim(@RequestParam("claimId") int claimId , Model model)
    {
        System.out.println("-------populateSearchedClaim ------------");
        Claim claim=claimPatientService.fetchClaim(claimId);

        claim.getCharges().forEach(System.out::println);
        System.out.println("------------------------");

        model.addAttribute("claim" , claim);
        System.out.println("-------populateSearchedClaim END ------------");

        return "populateClaim";
    }

    @RequestMapping("/newClaim")
    public String newClaimGeneration(@RequestParam("patientId") int patientId ,Model model)
    {
        System.out.println("-------newClaimGeneration ------------");

        PatientDetails patientDetails = claimPatientService.getPatientDetail(patientId);
        Claim claim = new Claim();
        claim.setPatientDetails(patientDetails);
        model.addAttribute("claim" , claim);
        System.out.println("-------newClaimGeneration END------------");
        return "populateClaim";
    }
}
