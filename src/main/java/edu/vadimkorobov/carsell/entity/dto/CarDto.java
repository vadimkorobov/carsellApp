package edu.vadimkorobov.carsell.entity.dto;


import lombok.*;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CarDto implements Serializable {


    private String model;
    private String engineType;
    private String color;
    private int carPrice;
    private int numberOfCarOwners;
    private int carMileage;
    private int power;
    private String picture;


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(int carPrice) {
        this.carPrice = carPrice;
    }

    public int getNumberOfCarOwners() {
        return numberOfCarOwners;
    }

    public void setNumberOfCarOwners(int numberOfCarOwners) {
        this.numberOfCarOwners = numberOfCarOwners;
    }

    public int getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(int carMileage) {
        this.carMileage = carMileage;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
