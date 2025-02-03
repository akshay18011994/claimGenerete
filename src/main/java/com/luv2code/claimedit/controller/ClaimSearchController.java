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
    public String searchPatientClaims(@ModelAttribute PatientDetails patientDetails , Model model)
    {
        List<Claim> claimList = new ArrayList<>();
        if(null != patientDetails.getPatientName()) {
            claimList = claimPatientService.getPatientClaims(patientDetails);
        }
        model.addAttribute("patientDetails",patientDetails);
        if(claimList.size()>0) {
            model.addAttribute("listClaims", claimList);
        }
        return "searchPatientClaims";

    }
}
