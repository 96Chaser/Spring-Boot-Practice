package com.zetcode.repository;

import com.zetcode.model.City;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends CrudRepository<City, Long> {

    @Query("FROM City ORDER BY population ASC")
    List<City> findAllOrderByPopulationAsc();

    @Query("FROM City ORDER BY name ASC")
    List<City> findAllOrderByNameAsc();

}