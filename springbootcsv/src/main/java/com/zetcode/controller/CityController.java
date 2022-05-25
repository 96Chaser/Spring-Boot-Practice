package com.zetcode.controller;

import com.zetcode.model.City;
import com.zetcode.service.ICityService;
import com.zetcode.util.WriteCsvToResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class CityController {

    private final ICityService cityService;

    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "/cities", produces = "text/csv")
    public void findCities(HttpServletResponse response) throws IOException {

        List<City> cities = cityService.findAll();

        WriteCsvToResponse.writeCities(response.getWriter(), cities);
    }

    @RequestMapping(value = "/cities/{cityId}", produces = "text/csv")
    public void findCity(@PathVariable Long cityId, HttpServletResponse response) throws IOException {

        City city = cityService.findById(cityId);
        WriteCsvToResponse.writeCity(response.getWriter(), city);
    }
}