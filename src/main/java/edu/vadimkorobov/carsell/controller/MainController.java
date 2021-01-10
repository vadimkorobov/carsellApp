package edu.vadimkorobov.carsell.controller;

import edu.vadimkorobov.carsell.entity.Car;
import edu.vadimkorobov.carsell.entity.dto.CarDto;
import edu.vadimkorobov.carsell.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

@Autowired
    CarService carService;

    @ModelAttribute("cars")
    public List<CarDto> cars() {
        //todo Mapper
        List<CarDto> cars= carService.getAll();
        return cars;
    }
    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        return "login";
    }


}
