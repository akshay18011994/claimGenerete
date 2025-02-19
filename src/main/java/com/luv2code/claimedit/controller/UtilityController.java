package com.luv2code.claimedit.controller;

import com.luv2code.claimedit.entity.DiagnosisMaster;
import com.luv2code.claimedit.utility.ClaimUtilityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UtilityController {

    @Autowired
    ClaimUtilityHelper claimUtilityHelper;

    @GetMapping("/getDiagnosisCodeDesc")
    public ResponseEntity<Map<String,String>> getDiagnosisCodeDesc(@RequestParam("code") String code , Model model)
    {
        Map<String, String> response = new HashMap<>();

        DiagnosisMaster diagnosisMaster = claimUtilityHelper.fetchDiagnosisCodeDesc(code);
        if(null != diagnosisMaster && null!=diagnosisMaster.getDiagnosisCodeDesc()) {
            response.put("description", diagnosisMaster.getDiagnosisCodeDesc());
        }
        else {
            response.put("description", "invalid code");

        }
        return ResponseEntity.ok(response);
    }
}
