package com.hackteam.dtp.controller;

import io.swagger.annotations.ApiImplicitParam;
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

    @ApiImplicitParam(name = "Authorization", paramType = "header", required = true, dataType = "string")
    @ResponseBody
    @RequestMapping(value = "/secure", method = RequestMethod.GET)
    public String testSecure() {

        return "Your token is correct! KRASAVA";
    }
}
