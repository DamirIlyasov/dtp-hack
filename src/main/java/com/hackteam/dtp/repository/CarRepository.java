package com.hackteam.dtp.repository;

import com.hackteam.dtp.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findOneByCarNumber(String carNumber);
}
