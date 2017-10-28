package com.hackteam.dtp.controller;

import com.hackteam.dtp.dto.DtpDto;
import com.hackteam.dtp.dto.converter.DtpConverter;
import com.hackteam.dtp.dto.converter.UserToDtoConverter;
import com.hackteam.dtp.model.Car;
import com.hackteam.dtp.model.DangerousZones;
import com.hackteam.dtp.model.Dtp;
import com.hackteam.dtp.model.User;
import com.hackteam.dtp.service.*;
import com.hackteam.dtp.util.ApiResponse;
import com.hackteam.dtp.util.ResponseCreator;
import com.hackteam.dtp.util.requests.RegisterDtpJson;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/secure/v1")
public class DtpController extends ResponseCreator {

    @Autowired
    DtpService dtpService;

    @Autowired
    CarService carService;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserService userService;

    @Autowired
    UserToDtoConverter userToDtoConverter;

    @Autowired
    DtpConverter dtpConverter;

    @Autowired
    DangerousZoneService dangerousZoneService;

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/dtp", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<String>> registerDtp(@RequestBody RegisterDtpJson request) throws IOException {
        //first car
        Car firstCar = carService.findOneByCarNumber(request.getFirstUserCarNumber());

        User secondUser = userService.findOneByPhone(request.getSecondUsersPhoneNumber());
        //second car
        Car secondCar = new Car();
        for (Car car : secondUser.getCars()) {
            if (car.getCarNumber().equals(request.getSecondUsersCarNumber())) {
                secondCar = car;
            }
        }

        User firstUser = securityService.getCurrentUser();
        Dtp dtp = new Dtp();
        dtp.setFullDtpPlace(request.getFullDtpPlace());
        dtp.setDate(request.getDate());
        dtp.setCarCrashedCount(request.getCarCrashedCount());
        dtp.setVictimsNumbers(request.getVictimsNumbers());
        dtp.setMatherialDamageToTransportExceptAandB(request.isMatherialDamageToTransportExceptAandB());
        dtp.setMatherialDamagToDifferentThinks(request.isMatherialDamagToDifferentThinks());
        dtp.setWitnessesFullNameAndAdresses(request.getWitnessesFullNameAndAdresses());
        dtp.setLatitude(request.getLatitude());
        dtp.setLongitude(request.getLongitude());
        dtp.setFirstUser(firstUser);
        dtp.setSecondUser(secondUser);
        dtp.setFirstCar(firstCar);
        dtp.setSecondCar(secondCar);
        dtpService.save(dtp);


        DtpDto dtpDto = dtpConverter.convert(dtp);


        for (SseEmitter e : MainController.emitters) {
            e.send(dtpDto);
        }
        return createGoodResponse();
    }


    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/dtp/not_finished", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<DtpDto>>> getAllNotFinishedDtp() {
        return createGoodResponse(dtpConverter.convertList(dtpService.findAllByFinishedFalse()));
    }


    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/dtp/finished", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<DtpDto>>> getAllFinishedDtp() {
        return createGoodResponse(dtpConverter.convertList(dtpService.findAllByFinishedTrue()));

    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/dtp", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<DtpDto>> getDtpBuId(@RequestParam("id") Long id) {
        return createGoodResponse(dtpConverter.convert(dtpService.findOneById(id)));
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/dangerous", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<DangerousZones>>> getDangerousZones() {
        return createGoodResponse(dangerousZoneService.getAll());
    }

}
