package com.hackteam.dtp.dto.converter;

import com.hackteam.dtp.dto.UserDto;
import com.hackteam.dtp.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserToDtoConverter {
    public UserDto convert(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setMiddleName(user.getMiddleName());
        userDto.setEmail(user.getEmail());
        userDto.setPhone(user.getPhone());
        userDto.setLicenseSerial(user.getLicenseSerial());
        userDto.setLicenseNumber(user.getLicenseNumber());
        userDto.setInn(user.getInn());
        userDto.setGender(user.getGender());
        userDto.setBirthday(user.getBirthday());
        userDto.setBirthPlace(user.getBirthPlace());
        userDto.setRegistrationAdress(user.getRegistrationAdress());
        userDto.setCitizenship(user.getCitizenship());
        userDto.setDrivingExperience(user.getDrivingExperience());
        userDto.setPassSeria(user.getPassSeria());
        userDto.setPassNumber(user.getPassNumber());
        userDto.setPassGettingDate(user.getPassGettingDate());
        userDto.setWhoGivedPass(user.getWhoGivedPass());
        userDto.setSnils(user.getSnils());
        return userDto;
    }
}
