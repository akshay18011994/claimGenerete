package com.luv2code.claimedit.controller;

import com.luv2code.claimedit.entity.Charge;
import com.luv2code.claimedit.entity.Claim;
import com.luv2code.claimedit.entity.PatientDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class ClaimEditController {

    @RequestMapping("/")
    public String populateClaims(Model model)
    {
        Claim claim = new Claim();
        PatientDetails pd = new PatientDetails("AA", LocalDate.of(1994,12,1), "222");
        List<String> listDiagnosis =Arrays.asList("s1","s2");
        Charge c1 = new Charge(1,"92345", listDiagnosis,new BigDecimal(20),new BigDecimal(20),new BigDecimal(0),91231);
        Charge c2 = new Charge(2,"92345",listDiagnosis,new BigDecimal(20),new BigDecimal(20),new BigDecimal(0),91231);

        List<Charge> listCharges = Arrays.asList(c1,c2);
        claim.setPatientDetails(pd);
        claim.setCharges(listCharges);
        model.addAttribute("claim" , claim);

        return "populateClaim";
    }

    @RequestMapping("/process")
    public String processClaim(@ModelAttribute Claim claim)
    {
        System.out.println(claim.getCharges().size());
        return "populateClaim";
    }
}
