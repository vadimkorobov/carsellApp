package edu.vadimkorobov.carsell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={
        "edu.vadimkorobov.carsell"})
public class CarSellApp {

    public static void main(String[] args) {
        SpringApplication.run(CarSellApp.class, args);
    }

}
