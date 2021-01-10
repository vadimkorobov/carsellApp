package edu.vadimkorobov.carsell.services;

import edu.vadimkorobov.carsell.entity.Car;
import edu.vadimkorobov.carsell.entity.dto.CarDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CarService {

    Car addCar(Car car);

    void delete(long id);

    Car getById(long id);

    Car editCar(Car car);

    List<CarDto> getAll();

}

