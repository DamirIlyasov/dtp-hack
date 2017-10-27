package com.hackteam.dtp.controller;


import com.hackteam.dtp.model.Car;
import com.hackteam.dtp.model.User;
import com.hackteam.dtp.service.CarService;
import com.hackteam.dtp.service.SecurityService;
import com.hackteam.dtp.util.ApiResponse;
import com.hackteam.dtp.util.ResponseCreator;
import com.hackteam.dtp.util.requests.AddCarJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/secure/v1")
public class UserController extends ResponseCreator {
    @Autowired
    SecurityService securityService;

    @Autowired
    CarService carService;

    @RequestMapping(value = "/user/car", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<Object>> addCar(@RequestBody AddCarJson request) {
        User currentUser = securityService.getCurrentUser();
        Car car = new Car();
        car.setCarMark(request.getCarMark());
        car.setCarModel(request.getCarModel());
        car.setCarNumber(request.getCarNumber());
        car.setCarYearOfBuilding(request.getCarYearOfBuilding());
        car.setHorsePower(request.getHorsePower());
        car.setInsurancePolicyNumber(request.getInsurancePolicyNumber());
        car.setInsurancePolicySerial(request.getInsurancePolicySerial());
        car.setPtsNumber(request.getPtsNumber());
        car.setPtsSerialNumber(request.getPtsSerialNumber());
        car.setVinNumber(request.getVinNumber());
        car.setWhoGivedPts(request.getWhoGivedPts());
        car.setUser(currentUser);
        carService.save(car);
        return createGoodResponse();
    }

//    @RequestMapping(value = "/user/fill_data", method = RequestMethod.POST)
//    public ResponseEntity<ApiResponse<Object>> fillData(){
//
//    }
}
