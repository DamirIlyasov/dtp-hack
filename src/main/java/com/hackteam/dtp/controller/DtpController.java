package com.hackteam.dtp.controller;

import com.hackteam.dtp.dto.DtpDto;
import com.hackteam.dtp.dto.converter.CarDtoConverter;
import com.hackteam.dtp.dto.converter.DtpConverter;
import com.hackteam.dtp.dto.converter.UserToDtoConverter;
import com.hackteam.dtp.model.DangerousZones;
import com.hackteam.dtp.model.Dtp;
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

    @Autowired
    CarDtoConverter carDtoConverter;

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/dtp", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<String>> registerDtp(@RequestBody RegisterDtpJson request) throws IOException {

        try {


            //first car
//            Car firstCar = carService.findOneByCarNumber(request.getFirstUserCarNumber());


//            User secondUser = userService.findOneByPhone(request.getSecondUsersPhoneNumber());
//            System.out.println("--------------------------------");
//            System.out.println(secondUser.toString());
//            System.out.println("--------------------------------");

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
//            dtp.setSecondUser(secondUser);
//            dtp.setFirstCar(firstCar);
            dtpService.save(dtp);
            DtpDto dtpDto = dtpConverter.convert(dtp);
            for (SseEmitter e : MainController.emitters) {
                e.send(dtpDto);
            }

        } catch (Exception e) {
            System.out.println("-----------------------------");
            System.out.println(e.getMessage());
            System.out.println("-----------------------------");
            e.printStackTrace();
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

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/dtp/last", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<DtpDto>>> lastDtp() {
        List<Dtp> last = dtpService.getLast();
        System.out.println("LAST:" + last.toString());
        List<DtpDto> dtos = dtpConverter.convertList(dtpService.getLast());
        System.out.println();
        return createGoodResponse(dtos);
    }

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/close_dtp", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<String>> getDangerousZones(@RequestParam("id") Long id) {
        try {
            Dtp dtp = dtpService.findOneById(id);
            dtp.setFinished(true);
            dtpService.save(dtp);
            return createGoodResponse();
        } catch (Exception e) {
            return createBadResponse(e.getMessage());
        }
    }
}
