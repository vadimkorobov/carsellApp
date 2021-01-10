package edu.vadimkorobov.carsell.entity;


import javax.persistence.*;

@Entity
@Table(name = "car", schema = "public")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String model;

    @Column(name = "engine_type")
    private String engineType;


    @Column
    private String color;

    @Column(name = "car_price")
    private int carPrice;

    @Column(name = "number_of_car_owners")
    private int numberOfCarOwners;

    @Column(name = "car_mileage")
    private int carMileage;

    @Column
    private int power;

    @Column
    private byte[]  picture;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

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

    public byte[]  getPicture() {
        return picture;
    }

    public void setPicture(byte[]  picture) {
        this.picture = picture;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//getters and setters
}