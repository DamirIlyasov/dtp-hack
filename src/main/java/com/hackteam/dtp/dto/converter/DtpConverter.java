package com.hackteam.dtp.dto.converter;

import com.hackteam.dtp.dto.DtpDto;
import com.hackteam.dtp.model.Dtp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtpConverter {
    @Autowired
    UserToDtoConverter userToDtoConverter;

    public DtpDto convert(Dtp dtp) {
        DtpDto dtpDto = new DtpDto();
        dtpDto.setId(dtp.getId());
        dtpDto.setFullDtpPlace(dtp.getFullDtpPlace());
        dtpDto.setDate(dtp.getDate());
        dtpDto.setCarCrashedCount(dtp.getCarCrashedCount());
        dtpDto.setVictimsNumbers(dtp.getVictimsNumbers());
        dtpDto.setMatherialDamageToTransportExceptAandB(dtp.isMatherialDamageToTransportExceptAandB());
        dtpDto.setMatherialDamagToDifferentThinks(dtp.isMatherialDamagToDifferentThinks());
        dtpDto.setWitnessesFullNameAndAdresses(dtp.getWitnessesFullNameAndAdresses());
        dtpDto.setLatitude(dtp.getLatitude());
        dtpDto.setLongitude(dtp.getLongitude());
        try {
            dtpDto.setFirstUser(userToDtoConverter.convert(dtp.getFirstUser()));
            dtpDto.setSecondUser(userToDtoConverter.convert(dtp.getFirstUser()));
        } catch (Exception e) {
            dtpDto.setFirstUser(null);
            dtpDto.setSecondUser(null);
        } finally {
            dtpDto.setFirstUsersName("Иванов Иван Иванович");
            dtpDto.setSecondUsersName("Антонов Антон Дмитриевич");
        }

        dtpDto.setFirstCar(dtp.getFirstCar());
        dtpDto.setSecondCar(dtp.getSecondCar());
        return dtpDto;
    }

    public List<DtpDto> convertList(List<Dtp> dtps) {
        List<DtpDto> dtpDtos = new ArrayList<>();
        for (Dtp d : dtps) {
            dtpDtos.add(convert(d));
        }
        return dtpDtos;
    }
}
