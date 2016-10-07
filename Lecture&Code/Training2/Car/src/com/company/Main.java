package com.company;

import car.Car;
import car.DieselCar;
import car.GasolineCar;

public class Main {

    public static void main(String[] args) {
        Car vw = new DieselCar();
        Car mers = new GasolineCar();
        Car[] cars = new Car[] {vw, mers};
        for (Car car : cars) {
            car.fillIn(3);
            car.accelerate();
        }
    }
}
