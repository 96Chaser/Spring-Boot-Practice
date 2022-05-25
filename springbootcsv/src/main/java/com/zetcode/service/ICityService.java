package com.zetcode.service;

import com.zetcode.model.City;
import java.util.List;

public interface ICityService {

    List<City> findAll();
    City findById(Long id);
}