package com.tdd.testbeforeanything.service;

import com.tdd.testbeforeanything.CarNotFoundException;
import com.tdd.testbeforeanything.domain.Car;
import com.tdd.testbeforeanything.repository.CarRepository;

public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car getCarDetails(String name) {
        Car car = this.carRepository.findByName(name);
        if (car == null) {
            throw new CarNotFoundException();
        }
        return car;
    }
}
