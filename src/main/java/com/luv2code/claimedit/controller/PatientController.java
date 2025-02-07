package com.luv2code.claimedit.controller;

import com.luv2code.claimedit.entity.PatientDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PatientController {

    @RequestMapping("/registerPatient")
    public String registerPatient(Model model)
    {
        model.addAttribute("patientDetails" , new PatientDetails());
        return "patientRegister";
    }

    @RequestMapping("/savePatient")
    public String savePatient(Model model , @ModelAttribute("patientDetails") PatientDetails patientDetails)
    {
        System.out.println(patientDetails);
        model.addAttribute("patientDetails" , patientDetails);
        return "patientRegister";
    }
}
