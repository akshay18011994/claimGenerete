package com.luv2code.claimedit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UtilityController {

    @GetMapping("/getDiagnosisCodeDesc")
    public ResponseEntity<Map<String,String>> getDiagnosisCodeDesc(@RequestParam("code") String code , Model model)
    {
        Map<String, String> response = new HashMap<>();
        if((code.toLowerCase()).equals("s1")) {
            response.put("description", "Pain in Chest");
        }
        else if((code.toLowerCase()).equals("s2")){
            response.put("description", "knee pain");
        }
        else {
            response.put("description", "invalid code");

        }
        return ResponseEntity.ok(response);
    }
}
