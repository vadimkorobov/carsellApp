package edu.vadimkorobov.carsell.services.impl;

import edu.vadimkorobov.carsell.entity.Car;
import edu.vadimkorobov.carsell.entity.dto.CarDto;
import edu.vadimkorobov.carsell.repository.CarRepository;
import edu.vadimkorobov.carsell.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static edu.vadimkorobov.carsell.util.Util.decompressBytes;

@Service
public class CarServiceImpl implements CarService {


    @Autowired
    private CarRepository carRepository;

    @Override
    public Car addCar(Car car) {
        Car savedCar = carRepository.saveAndFlush(car);

        return savedCar;
    }

    @Override
    public void delete(long id) {
        carRepository.delete(id);
    }

    @Override
    public Car getById(long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car editCar(Car car) {
        return carRepository.saveAndFlush(car);
    }

    @Override
    public List<CarDto> getAll() {
        List<CarDto> carDtos=new ArrayList<>();
       List<Car> cars=carRepository.findAll();
       for(Car car: cars){
        CarDto dto=   CarDto.builder().model(car.getModel())
                   .carPrice(car.getCarPrice())
                   .picture(Base64.getEncoder().encodeToString(decompressBytes(car.getPicture()))).build();
                   carDtos.add(dto);
       }
       return carDtos;
    }
}

