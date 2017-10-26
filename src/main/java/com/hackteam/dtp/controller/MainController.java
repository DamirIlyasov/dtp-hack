package com.hackteam.dtp.controller;

import io.swagger.annotations.ApiImplicitParam;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHelloMessage() {
        return "Server online.";
    }


    @RequestMapping("/sseTest")
    public ResponseBodyEmitter handleRequest() {

        final SseEmitter emitter = new SseEmitter();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    emitter.send(LocalTime.now().toString(), MediaType.TEXT_EVENT_STREAM);

                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                    emitter.completeWithError(e);
                    return;
                }
            }
            emitter.complete();
        });

        return emitter;
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
