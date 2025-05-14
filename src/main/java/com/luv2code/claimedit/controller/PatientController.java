package com.luv2code.claimedit.controller;

import com.luv2code.claimedit.entity.PatientDetails;
import com.luv2code.claimedit.service.ClaimPatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PatientController {

    @Autowired
    ClaimPatientService claimPatientService;

    @RequestMapping("/registerPatient")
    public String registerPatient(Model model)
    {
        model.addAttribute("patientDetails" , new PatientDetails());
        return "patientRegister";
    }

    @RequestMapping("/savePatient")
    public String savePatient(Model model , @ModelAttribute("patientDetails") @Valid PatientDetails patientDetails, BindingResult bindingResult)
    {
        System.out.println(patientDetails);
        if(bindingResult.hasErrors())
        {
            return  "patientRegister";
        }
        patientDetails=claimPatientService.savePatientDetails(patientDetails);
        System.out.println("-----------------");
        System.out.println(patientDetails);
        model.addAttribute("patientDetails" , patientDetails);
        model.addAttribute("patientDetailsSave" , "patientDetailsSave");
        return "patientRegister";
    }

   @RequestMapping("/getPatient")
    public String getPatientDetails(@RequestParam("patientId") int patientId ,Model model)
   {
       PatientDetails patientDetails= claimPatientService.getPatientDetail(patientId);
       model.addAttribute("patientDetails" , patientDetails);
       return "patientRegister";
   }

}
