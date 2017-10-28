package com.hackteam.dtp.util;

import com.hackteam.dtp.model.Car;
import com.hackteam.dtp.model.Dtp;
import com.hackteam.dtp.model.User;
import com.hackteam.dtp.service.DtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Dmitry on 28.10.2017.
 */

@Component
public class Generation {

    @Autowired
    DtpService dtpService;

    @Autowired
    hui hui;

    @PostConstruct
    private void main() {
//        double corda1 = 55.787822;
//        double corda2 = 49.123248;
//        double cordb1 = 55.788066;
//        double cordb2 = 49.151599;
//        double cordc1 = 55.802628;
//        double cordc2 = 49.185631;
//        double cordd1 = 55.766720;
//        double cordd2 = 49.180016;
//        double corde1 = 55.752762;
//        double corde2 = 49.163406;
//        Random random = new Random();
//        dtpService.save(new Dtp(new Date(), corde1, corde2));
//        dtpService.save(new Dtp(new Date(), cordd1, cordd2));
//        dtpService.save(new Dtp(new Date(), cordc1, cordc2));
//        dtpService.save(new Dtp(new Date(), cordb1, cordb2));
//        dtpService.save(new Dtp(new Date(), corda1, corda2));
//        for (int i = 0; i < random.nextInt(20); i++) {
//            dtpService.save(new Dtp(new Date(), corde1 - random.nextDouble(), corde2 - random.nextDouble()));
//        }
//        for (int i = 0; i < random.nextInt(15); i++) {
//            dtpService.save(new Dtp(new Date(), cordd1 - random.nextDouble(), cordd2 - random.nextDouble()));
//        }
//        for (int i = 0; i < random.nextInt(10); i++) {
//            dtpService.save(new Dtp(new Date(), cordc1 - random.nextDouble(), cordc2 - random.nextDouble()));
//        }
//        for (int i = 0; i < random.nextInt(32); i++) {
//            dtpService.save(new Dtp(new Date(), cordb1 - random.nextDouble(), cordb2 - random.nextDouble()));
//        }
//        for (int i = 0; i < random.nextInt(18); i++) {
//            dtpService.save(new Dtp(new Date(), corda1 - random.nextDouble(), corda2 - random.nextDouble()));
//        }
        for(int i=0;i<500;i++){
            Random random = new Random();
            int j=random.nextInt(7);
            dtpService.save(new Dtp(generateDate(),generateLatitude(j),generateLongitud(j)));
        }
        hui.generateDangerousZones();
    }
//
//    private List<User> generateAndGetRandomUser() {
//        String[] name = {"Максим", "Александр", "Иван", "Дмитрий", "Артем", "Никита", "Даниил", "Михаил", "Андрей", "Егор"};
//        String[] lastname = {"Иванов","Смирнов","Кузнецов","Попов","Васильев","Петров","Соколов","Михайлов","Новиков","Федоров"	};
//        String[] middlename = {"Максимович", "Александрович", "Иванович", "Дмитревич", "Артемович", "Никитич", "Даниилович", "Михайлович", "Андреевич", "Егорович"};
//    }
//
//    private List<Car> generateAndGetRandomCars() {
//        Random random = new Random();
//        String name = "Машина"+random.nextInt(60);
//        int number = random.nextInt(899)+100;
//        String abc =
//    }

    private Date generateDate() {
        Random random = new Random();
        Date date = new Date(System.currentTimeMillis()-random.nextInt(750000000));
        return date;
    }

    private Double generateLatitude(int i) {
        List<Double> lat = new ArrayList<>();
        lat.add(55.824251);
        lat.add(55.802634);
        lat.add(55.764064);
        lat.add(55.796796);
        lat.add(55.813547);
        lat.add(55.833522);
        lat.add(55.826872);
        Random random = new Random();
        int diff = random.nextInt(100000)+50;
        int sign = random.nextInt(1)-1;
        if(sign==0){
            return lat.get(i)+diff/100000;
        }else return lat.get(i)-diff/100000;
    }

    private Double generateLongitud(int i) {
        List<Double> lon = new ArrayList<>();
        lon.add(49.104406);
        lon.add(49.181359);
        lon.add(49.168860);
        lon.add(49.108649);
        lon.add(49.074613);
        lon.add(49.071422);
        lon.add(49.109875);
        Random random = new Random();
        int diff = random.nextInt(100000)+50;
        int sign = random.nextInt(1)-1;
        if(sign==0){
            return lon.get(i)+diff/100000;
        }else return lon.get(i)-diff/100000;
    }
}
