package com.hackteam.dtp.controller;

import com.hackteam.dtp.model.Dtp;
import com.hackteam.dtp.service.DtpService;
import com.hackteam.dtp.service.SecurityService;
import com.hackteam.dtp.util.ApiResponse;
import com.hackteam.dtp.util.ResponseCreator;
import com.hackteam.dtp.util.requests.RegisterDtpJson;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/secure/v1")
public class DtpController extends ResponseCreator {

    @Autowired
    DtpService dtpService;

    @Autowired
    SecurityService securityService;

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/dtp", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<String>> registerDtp(@RequestBody RegisterDtpJson request) throws IOException {
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
        dtp.setUser(securityService.getCurrentUser());
        dtpService.save(dtp);
        for (SseEmitter e : MainController.emitters) {
            e.send(dtp);
        }
        return createGoodResponse();
    }


    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/dtp/not_finished", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<Dtp>>> getAllNotFinishedDtp() {
        return createGoodResponse(dtpService.findAllByFinishedFalse());
    }


    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/dtp/finished", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<Dtp>>> getAllFinishedDtp() {
        return createGoodResponse(dtpService.findAllByFinishedTrue());
    }

}
