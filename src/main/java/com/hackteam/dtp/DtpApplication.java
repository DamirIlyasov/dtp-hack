package com.hackteam.dtp;

import com.hackteam.dtp.model.Car;
import com.hackteam.dtp.model.Dtp;
import com.hackteam.dtp.model.User;
import com.hackteam.dtp.service.CarService;
import com.hackteam.dtp.service.DtpService;
import com.hackteam.dtp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DtpApplication {
    @Autowired
    UserService userService;

    @Autowired
    CarService carService;

    @Autowired
    DtpService dtpService;
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        SpringApplication.run(DtpApplication.class, args);
    }

    @PostConstruct
    public void createData() {
        Car car = new Car();
        car.setWhoGivedPts("Дамир");
        car.setVinNumber("123");
        car.setPtsSerialNumber("441");
        car.setInsurancePolicySerial("2222");
        car.setInsurancePolicyNumber("55555");
        car.setPtsNumber("1233");
        car.setHorsePower(900);
        car.setCarYearOfBuilding("1997");
        car.setCarModel("Opel");
        car.setCarMark("Astra");
        car.setCarNumber("ув218x116");
        carService.save(car);


        Car car1 = carService.findOneByCarNumber("ув218Х116");
        User user = new User();
        user.setAcceptPersonalDataTreatment(true);
        user.setPhone("89033885946");
        user.setSnils("123123");
        user.setWhoGivedPass("кто-то");
        user.setPassGettingDate(new Date());
        user.setPassSeria("серия паспорта");
        user.setDrivingExperience("2");
        user.setCitizenship("город какой-то");
        user.setRegistrationAdress("дом");
        user.setBirthPlace("дом");
        user.setEmail("adminadmin@gmail.com");
        user.setPassword(encoder.encode("123qwe123"));
        user.setFirstName("Damir");
        user.setLastName("Ilyasov");
        user.setPassNumber("123123");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        user.setCars(cars);
        userService.save(user);

        Car car2 = carService.findOneByCarNumber("Лe228Х116");
        Dtp dtp = new Dtp();
        dtp.setFirstCar(car1);
        dtp.setSecondCar(car2);
        dtp.setDate(new Date());
        dtp.setLatitude(55.752762);
        dtp.setLongitude(49.163406);
        dtp.setFullDtpPlace("У Лии дома");
        dtp.setFirstUser(userService.findOneByEmail("adminadmin@gmail.com"));
        dtp.setSecondUser(userService.findOneByEmail("adminadmin@gmail.com"));
        dtp.setLatitude(55.76672);
        dtp.setLongitude(49.180016);
        dtpService.save(dtp);
    }
}
