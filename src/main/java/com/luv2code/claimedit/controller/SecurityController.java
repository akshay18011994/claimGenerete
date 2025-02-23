package com.luv2code.claimedit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/showMyLoginForm")
    public String loginForm()
    {
        System.out.println("inside the showLoginForm");
        return "login";
    }
    @GetMapping("/logout")
    public String logout() {
        // Perform logout logic here
        return "redirect:/showMyLoginForm";
    }
}

