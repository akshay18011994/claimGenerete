package com.luv2code.claimedit.controller;

import com.luv2code.claimedit.entity.Claim;
import com.luv2code.claimedit.entity.PatientDetails;
import com.luv2code.claimedit.service.ClaimPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ClaimSearchController {

    @Autowired
    ClaimPatientService claimPatientService;

    @RequestMapping("/searchPatientClaims")
    public String searchPatientClaimsForm(@ModelAttribute PatientDetails patientDetails , Model model)
    {
        model.addAttribute("patientExist" , true);
        model.addAttribute("patientDetails",patientDetails);

        return "searchPatientClaims";
    }
    @RequestMapping("/searchPatient")
    public String searchPatientClaims(@ModelAttribute PatientDetails patientDetails , Model model)
    {
        System.out.println("-------searchPatientClaims----------");
        List<Claim> claimList = new ArrayList<>();
        patientDetails  = claimPatientService.getPatientClaims(patientDetails);

        if(null !=patientDetails.getEmail() || null !=patientDetails.getAddress())
        {
            model.addAttribute("patientExist" , true);
        }
        else {
            model.addAttribute("patientExist" , false);
        }
        System.out.println(patientDetails);
        model.addAttribute("patientDetails",patientDetails);
        model.addAttribute("listClaims", patientDetails.getClaims());
        System.out.println("-------searchPatientClaims end ----------");
        return "searchPatientClaims";

    }
}
