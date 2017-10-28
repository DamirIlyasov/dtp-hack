package com.hackteam.dtp.service;

import com.hackteam.dtp.model.Car;

public interface CarService {
    void save(Car car);

    Car findOneByCarNumber(String carNumber);
}
