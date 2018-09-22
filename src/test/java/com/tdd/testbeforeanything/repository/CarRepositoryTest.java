package com.tdd.testbeforeanything.repository;


import com.tdd.testbeforeanything.domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest

public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void getCar_returnCarDetails() throws Exception {

        // entity manager flush find is imp to simulate real DB behaviour and to avoid getting
        // data from first level cache only. so always use entity manager
        // avoid : carRepository.save(new Car("prius", "hybrid"));

        Car savedCar = entityManager.persistFlushFind(new Car("prius", "hybrid"));

        Car car = carRepository.findByName("prius");

        assertThat(car.getName()).isEqualTo("prius");
        assertThat(car.getType()).isEqualTo("hybrid");

    }
}