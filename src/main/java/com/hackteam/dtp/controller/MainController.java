package com.hackteam.dtp.controller;

import io.swagger.annotations.ApiImplicitParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    public static List<SseEmitter> emitters = new ArrayList<>();

    @CrossOrigin
    @RequestMapping(value = "/sseTest", method = RequestMethod.GET)
    public ResponseBodyEmitter handleRequest() {
        final SseEmitter emitter = new SseEmitter();
        emitters.add(emitter);
        return emitter;
    }

    @CrossOrigin
    @RequestMapping("/test")
    public void test() throws IOException {
        for (SseEmitter e :
                emitters) {
            e.send("Kek");
        }
    }


    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @RequestMapping(value = "/secure", method = RequestMethod.GET)
    public String testSecure() {

        return "Your token is correct! KRASAVA";
    }
//    @PostConstruct
//    private void test(){
//        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> a = restTemplate.getForEntity("localhost/sseTest", String.class);
//        System.out.println(a.getBody());
//    }
}
