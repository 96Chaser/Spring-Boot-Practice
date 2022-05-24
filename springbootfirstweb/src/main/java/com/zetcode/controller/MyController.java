package com.zetcode.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDate;
import java.util.Map;

@Controller
public class MyController {

    @Value("${application.message}")
    private String message = "Hi there";

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("now", LocalDate.now());
        model.addAttribute("message", this.message);

        return "index";
    }
}