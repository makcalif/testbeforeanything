package com.tdd.testbeforeanything.repository;

import com.tdd.testbeforeanything.domain.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CarRepository extends CrudRepository<Car, Long> {

    @Query("select car from Car car where car.name = :name")
    public Car findByName(@Param("name") String name);
}
