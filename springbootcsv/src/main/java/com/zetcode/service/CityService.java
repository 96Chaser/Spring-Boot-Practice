package com.zetcode.service;

import com.zetcode.model.City;
import com.zetcode.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {

    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<City> findAll() {

        return  (List<City>) repository.findAll();
    }

    @Override
    public City findById(Long id) {

        return repository.findById(id).orElse(new City());
    }
}