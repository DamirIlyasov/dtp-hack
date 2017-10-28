package com.hackteam.dtp.dto.converter;

import com.hackteam.dtp.dto.CarDto;
import com.hackteam.dtp.model.Car;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDtoConverter {
    public CarDto convert(Car car) {
        CarDto carDto = new CarDto();
        carDto.setCarMark(car.getCarMark());
        carDto.setCarModel(car.getCarModel());
        carDto.setCarNumber(car.getCarNumber());
        carDto.setPtsNumber(car.getPtsNumber());
        carDto.setWhoGivedPts(car.getWhoGivedPts());
        carDto.setVinNumber(car.getVinNumber());
        carDto.setCarYearOfBuilding(car.getCarYearOfBuilding());
        carDto.setHorsePower(car.getHorsePower());
        carDto.setInsurancePolicyNumber(car.getInsurancePolicyNumber());
        carDto.setInsurancePolicySerial(car.getInsurancePolicySerial());
        return carDto;
    }

    public List<CarDto> convertList(List<Car> cars) {
        List<CarDto> dtos = new ArrayList<>();
        for (Car car :
                cars) {
            dtos.add(convert(car));
        }
        return dtos;
    }
}
