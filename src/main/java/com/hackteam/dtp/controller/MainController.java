package com.hackteam.dtp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHelloMessage() {
        return "Server online.";
    }

    @ResponseBody
    @RequestMapping(value = "/secure", method = RequestMethod.GET)
    public String testSecure() {
        return "Your token is correct! KRASAVA";
    }
}
