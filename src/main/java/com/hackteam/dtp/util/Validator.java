package com.hackteam.dtp.util;

import com.hackteam.dtp.service.UserService;
import com.hackteam.dtp.util.requests.RequestSignUpJson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class Validator extends ResponseCreator {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String USER_NAMES_REGEX = "^([а-яА-ЯёЁa-zA-Z]\\s*)+$";
    private final String EMAIL_REGEX = "^[-a-z0-9!#$%&'*+/=?^_`{|}~]+(\\.[-a-z0-9!#$%&'*+/=?^_`{|}~]+)*@([a-z0-9]([-a-z0-9]{0,61}[a-z0-9])?\\.)*(aero|arpa|asia|biz|cat|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|net|org|pro|tel|travel|[a-z][a-z])$";
    private final String PHONE_REGEX = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
    private final String PASSWORD_REGEX = ".{6,20}";
    private final String HOUSE_NUMBER_REGEX = "[0-9]+(\\.[0-9]+){0,1}";
    private final String ROOM_NUBER_REGEX = "[0-9]{1,4}";
    private final String EVENT_NAME_REGEX = ".{1,100}";
    private final String EVENT_DESCRIPTION_REGEX = "((\\s)|(.)){0,500}";
    private final String EVENT_TYPE_REGEX = ".{1,30}";
    private final String EVENT_ADDRESS_REGEX = ".{1,200}";

    private Pattern pattern;
    private Matcher matcher;

    private UserService userService;

    @Autowired
    public Validator(UserService userService) {
        this.userService = userService;
    }


    public ResponseEntity<ApiResponse<Object>> getRegistrationErrorResponse(RequestSignUpJson requestSignUpJson
    ) {

        if (!this.isNameCorrect(requestSignUpJson.getFirstName())) {
            logger.warn("Validator: firstname " + requestSignUpJson.getFirstName() + " is incorrect!");
            return createBadResponse("FirstName is incorrect", HttpStatus.OK);

        }
        if (!this.isNameCorrect(requestSignUpJson.getLastName())) {
            logger.warn("Validator: Lastname " + requestSignUpJson.getLastName() + " is incorrect!");
            return createBadResponse("LastName is incorrect", HttpStatus.OK);
        }
        if (requestSignUpJson.getMiddleName() != null && !"".equals(requestSignUpJson.getMiddleName())) {
            if (!isNameCorrect(requestSignUpJson.getMiddleName())) {
                return createBadResponse("MiddleName is incorrect", HttpStatus.OK);

            }
        }
        if (!this.isEmailCorrect(requestSignUpJson.getEmail())) {
            logger.warn("Validator: Email " + requestSignUpJson.getEmail() + " is incorrect!");
            return createBadResponse("Email is incorrect", HttpStatus.OK);
        }
        if (this.isEmailAlreadyRegistered(requestSignUpJson.getEmail())) {
            logger.warn("Validator: User with this email " + requestSignUpJson.getEmail() + " already registered!");
            return createBadResponse("User with this email already registered", HttpStatus.OK);
        }
        if (!this.isPhoneCorrect(requestSignUpJson.getPhone())) {
            logger.warn("Validator: Phone " + requestSignUpJson.getPhone() + " is incorrect!");
            return createBadResponse("Phone is incorrect", HttpStatus.OK);
        }
        if (this.isPhoneAlreadyRegistered(requestSignUpJson.getPhone())) {
            logger.warn("Validator: User with this phone " + requestSignUpJson.getPhone() + " already registered!");
            return createBadResponse("User with this phone already registered", HttpStatus.OK);
        }
        if (!this.isPasswordCorrect(requestSignUpJson.getPassword())) {
            logger.warn("Validator: Password " + requestSignUpJson.getPassword() + " is incorrect!");
            return createBadResponse("Password is incorrect", HttpStatus.OK);
        }

        return null;
    }


    public boolean isEmailValid(String email) {
        if (!this.isEmailCorrect(email)) {
            logger.warn("Validator: Email " + email + " is incorrect!");
            return false;
        }
        if (this.isEmailAlreadyRegistered(email)) {
            logger.warn("Validator: User with this email " + email + " already registered!");
            return false;
        }
        return true;
    }

    private boolean isEventDateCorrect(String date) {
        try {
            return new Long(date) > System.currentTimeMillis();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isEventNameCorrect(String name) {
        pattern = Pattern.compile(EVENT_NAME_REGEX);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private boolean isEventDescriptionCorrect(String description) {
        pattern = Pattern.compile(EVENT_DESCRIPTION_REGEX);
        matcher = pattern.matcher(description);
        return matcher.matches();
    }

    private boolean isEventTypeCorrect(String type) {
        pattern = Pattern.compile(EVENT_TYPE_REGEX);
        matcher = pattern.matcher(type);
        return matcher.matches();
    }

    private boolean isEventAddressCorrect(String address) {
        pattern = Pattern.compile(EVENT_ADDRESS_REGEX);
        matcher = pattern.matcher(address);
        return matcher.matches();
    }

    private boolean isEventCapacityCorrect(int capacity) {
        return capacity > 0;
    }

//    public boolean is

    private boolean isNameCorrect(String name) {
        pattern = Pattern.compile(USER_NAMES_REGEX);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    private boolean isEmailCorrect(String email) {
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isEmailAlreadyRegistered(String email) {
        return userService.findOneByEmail(email) != null;
    }

    private boolean isPhoneCorrect(String phone) {
        pattern = Pattern.compile(PHONE_REGEX);
        matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    private boolean isPhoneAlreadyRegistered(String phone) {
        return userService.findOneByPhone(phone) != null;
    }

    private boolean isHouseNumberCorrect(String houseNumber) {
        pattern = Pattern.compile(HOUSE_NUMBER_REGEX);
        matcher = pattern.matcher(houseNumber);
        return matcher.matches();
    }

    private boolean isRoomNumberCorrect(String roomNumber) {
        if (roomNumber == null || roomNumber.equals("")) {
            return true;
        }
        pattern = Pattern.compile(ROOM_NUBER_REGEX);
        matcher = pattern.matcher(roomNumber);
        return matcher.matches();
    }

    public boolean isPasswordCorrect(String password) {
        pattern = Pattern.compile(PASSWORD_REGEX);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
