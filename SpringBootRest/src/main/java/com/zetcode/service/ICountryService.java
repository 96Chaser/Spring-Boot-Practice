package com.zetcode.service;

import com.zetcode.bean.Country;
import java.util.ArrayList;

public interface ICountryService {

    public ArrayList<Country> findAll();
}