package com.hackteam.dtp.service.impl;

import com.hackteam.dtp.model.Car;
import com.hackteam.dtp.repository.CarRepository;
import com.hackteam.dtp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepository carRepository;

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car findOneByCarNumber(String carNumber) {
        return carRepository.findOneByCarNumber(carNumber);
    }
}
