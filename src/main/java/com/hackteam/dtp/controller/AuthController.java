package com.hackteam.dtp.controller;


import com.hackteam.dtp.model.User;
import com.hackteam.dtp.service.SecurityService;
import com.hackteam.dtp.service.UserService;
import com.hackteam.dtp.util.ApiResponse;
import com.hackteam.dtp.util.ResponseCreator;
import com.hackteam.dtp.util.Validator;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@RestController
@RequestMapping("/v1")
public class AuthController extends ResponseCreator {
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();
    @Autowired
    private Validator validator;
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityService securityService;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    @ApiOperation("Sign in")
    @RequestMapping(value = "/sign_in", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<Object>> loginAndGetToken(@RequestParam("email") String email,
                                                                @RequestParam("password") String password) {

        User user = userService.findOneByEmail(email);
        if (user == null) {
            return createBadResponse("Wrong email or password!", HttpStatus.BAD_REQUEST);
        }
        if (!encoder.matches(password, user.getPassword())) {
            return createBadResponse("Wrong email or password!", HttpStatus.BAD_REQUEST);
        }
        String token = securityService.generateToken(email, password);
        return createGoodResponse(token);
    }

    @ApiOperation("Sign up")
    @RequestMapping(value = "/sign_up", method = RequestMethod.POST)
    public ResponseEntity<ApiResponse<Object>> registerAndGetToken(@RequestParam("firstName") String firstName,
                                                                   @RequestParam("lastName") String lastName,
                                                                   @RequestParam(value = "middleName", required = false) String middleName,
                                                                   @RequestParam("email") String email,
                                                                   @RequestParam("phone") String phone,
                                                                   @RequestParam("password") String password) {
        LOGGER.info("----------------------------------------------");
        LOGGER.info("RegistrationController: validation started...");
        ResponseEntity<ApiResponse<Object>> response = validator.getRegistrationErrorResponse(firstName, lastName, middleName, email,
                phone, password);
        if (response != null) {
            LOGGER.info("RegistrationController: validation failed!");
            return response;
        } else {
//
            LOGGER.info("RegistrationController: validation success!");
            LOGGER.info("RegistrationController: new user saving...");

            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setMiddleName(middleName);
            user.setEmail(email);
            user.setPhone(phone);
            user.setPassword(encoder.encode(password));
            String verificationCode = UUID.randomUUID().toString();
            user.setVerificationCode(verificationCode);
            userService.save(user);
            LOGGER.info("RegistrationController: new user saved successfully!");
            String token = securityService.generateToken(email, password);
//            try {
//                emailService.sendVerifyAccountMessage(email, verificationCode);
//            } catch (RuntimeException e) {
//                LOGGER.error(e.getMessage());
//            }
            return createGoodResponse(token);
        }
    }
}
