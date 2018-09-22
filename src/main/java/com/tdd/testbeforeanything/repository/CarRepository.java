package com.tdd.testbeforeanything.repository;

import com.tdd.testbeforeanything.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

    @Query("select car from Car where car.name = :name")
    public Car findByName(String prius);
}
