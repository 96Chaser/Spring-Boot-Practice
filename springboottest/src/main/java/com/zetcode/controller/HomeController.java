package com.zetcode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.HashMap;

@Controller
public class HomeController {

    @RequestMapping(path = "/")
    public ModelAndView index() {

        var params = new HashMap<String, String>();

        var today = LocalDate.now();
        var dayOfWeek = today.getDayOfWeek().toString().toLowerCase();
        params.put("dow", dayOfWeek);

        return new ModelAndView("index", params);
    }
}