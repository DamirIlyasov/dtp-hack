//package com.hackteam.dtp.controller;
//
//import com.hackteam.dtp.model.Dtp;
//import com.hackteam.dtp.util.ApiResponse;
//import com.hackteam.dtp.util.requests.RegisterDtpJson;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/secure/v1")
//public class DtpController {
//
//    @RequestMapping(value = "/dtp", method = RequestMethod.POST)
//    public ResponseEntity<ApiResponse<String>> registerDtp(@RequestBody RegisterDtpJson request){
//        Dtp dtp = new Dtp();
//        dtp.setFullDtpPlace(request.getFullDtpPlace());
//        dtp.setDate(request.getDate());
//        dtp.setCarCrashedCount(request.getCarCrashedCount());
//        dtp.setVictimsNumbers(request.getVictimsNumbers());
//        dtp.setMatherialDamageToTransportExceptAandB(request.isMatherialDamageToTransportExceptAandB());
//        dtp.setMatherialDamagToDifferentThinks(request.isMatherialDamagToDifferentThinks());
//        dtp.setWitnessesFullNameAndAdresses(request.getWitnessesFullNameAndAdresses());
//
//    }
//}
