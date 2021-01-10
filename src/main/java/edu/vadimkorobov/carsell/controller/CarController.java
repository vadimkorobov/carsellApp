package edu.vadimkorobov.carsell.controller;

import edu.vadimkorobov.carsell.entity.Car;
import edu.vadimkorobov.carsell.entity.dto.CarDto;
import edu.vadimkorobov.carsell.services.CarService;
import edu.vadimkorobov.carsell.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

import static edu.vadimkorobov.carsell.util.Util.compressBytes;

@Controller
@RequestMapping("/addCar")
@RequiredArgsConstructor
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    private UserService userService;

    @ModelAttribute("car")
    public CarDto carDto() {
        return new CarDto();
    }

    @GetMapping
    public String addCar(HttpServletRequest request) {
        return "addCar";
    }

    @PostMapping
    public String addCar(@RequestParam("picture") MultipartFile picture,
                         @ModelAttribute("car") CarDto carDto,
                         BindingResult result, Principal principal) throws IOException {

        Car car = new Car();
        car.setColor(carDto.getColor());
        car.setModel(carDto.getModel());
        car.setEngineType(carDto.getEngineType());
        car.setCarPrice(carDto.getCarPrice());
        car.setNumberOfCarOwners(carDto.getNumberOfCarOwners());
        car.setCarMileage(carDto.getCarMileage());
        car.setPower(carDto.getPower());
        car.setUser(userService.getByLogin(principal.getName()));
        car.setPicture(compressBytes(picture.getBytes()));
        carService.addCar(car);
        return "redirect:/";
    }

}