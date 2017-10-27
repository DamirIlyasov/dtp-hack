package com.hackteam.dtp.controller;


import com.hackteam.dtp.model.Car;
import com.hackteam.dtp.model.User;
import com.hackteam.dtp.service.CarService;
import com.hackteam.dtp.service.SecurityService;
import com.hackteam.dtp.service.UserService;
import com.hackteam.dtp.util.ApiResponse;
import com.hackteam.dtp.util.ResponseCreator;
import com.hackteam.dtp.util.requests.AddCarJson;
import com.hackteam.dtp.util.requests.FillUserDataJson;
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

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/car", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<String>> addCar(@RequestBody AddCarJson request) {
        try {
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
        } catch (Exception e) {
            return createBadResponse(e.getMessage());
        }
        return createGoodResponse();
    }

    @RequestMapping(value = "/user/fill_data", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<String>> fillData(@RequestBody FillUserDataJson request) {
        try {
            User currentUser = securityService.getCurrentUser();
            currentUser.setLicenseSerial(request.getLicenseSerial());
            currentUser.setLicenseNumber(request.getLicenseNumber());
            currentUser.setInn(request.getInn());
            currentUser.setGender(request.getGender());
            currentUser.setBirthday(request.getBirthday());
            currentUser.setBirthPlace(request.getBirthPlace());
            currentUser.setRegistrationAdress(request.getRegistrationAdress());
            currentUser.setCitizenship(request.getCitizenship());
            currentUser.setDrivingExperience(request.getDrivingExperience());
            currentUser.setPassSeria(request.getPassSeria());
            currentUser.setPassGettingDate(request.getPassGettingDate());
            currentUser.setWhoGivedPass(request.getWhoGivedPass());
            currentUser.setSnils(request.getSnils());
            currentUser.setAcceptPersonalDataTreatment(request.getAcceptPersonalDataTreatment());
            userService.save(currentUser);
        } catch (Exception e) {
            return createBadResponse(e.getMessage());
        }
        return createGoodResponse();
    }
}
