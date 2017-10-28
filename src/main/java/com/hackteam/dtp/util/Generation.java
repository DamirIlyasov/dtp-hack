package com.hackteam.dtp.util;

import com.hackteam.dtp.model.Dtp;
import com.hackteam.dtp.service.DtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Random;

/**
 * Created by Dmitry on 28.10.2017.
 */

@Component
public class Generation {

    @Autowired
    DtpService dtpService;

    private void main() {
        double corda1 = 55.787822;
        double corda2 = 49.123248;
        double cordb1 = 55.788066;
        double cordb2 = 49.151599;
        double cordc1 = 55.802628;
        double cordc2 = 49.185631;
        double cordd1 = 55.766720;
        double cordd2 = 49.180016;
        double corde1 = 55.752762;
        double corde2 = 49.163406;
        Random random = new Random();
        dtpService.save(new Dtp(new Date(), corde1, corde2));
        dtpService.save(new Dtp(new Date(), cordd1, cordd2));
        dtpService.save(new Dtp(new Date(), cordc1, cordc2));
        dtpService.save(new Dtp(new Date(), cordb1, cordb2));
        dtpService.save(new Dtp(new Date(), corda1, corda2));
        for (int i = 0; i < random.nextInt(20); i++) {
            dtpService.save(new Dtp(new Date(), corde1 - random.nextDouble(), corde2 - random.nextDouble()));
        }
        for (int i = 0; i < random.nextInt(15); i++) {
            dtpService.save(new Dtp(new Date(), cordd1 - random.nextDouble(), cordd2 - random.nextDouble()));
        }
        for (int i = 0; i < random.nextInt(10); i++) {
            dtpService.save(new Dtp(new Date(), cordc1 - random.nextDouble(), cordc2 - random.nextDouble()));
        }
        for (int i = 0; i < random.nextInt(32); i++) {
            dtpService.save(new Dtp(new Date(), cordb1 - random.nextDouble(), cordb2 - random.nextDouble()));
        }
        for (int i = 0; i < random.nextInt(18); i++) {
            dtpService.save(new Dtp(new Date(), corda1 - random.nextDouble(), corda2 - random.nextDouble()));
        }
    }
}
