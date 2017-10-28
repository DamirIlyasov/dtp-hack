package com.hackteam.dtp.util;

import com.hackteam.dtp.model.DangerousZones;
import com.hackteam.dtp.model.Dtp;
import com.hackteam.dtp.service.DangerousZoneService;
import com.hackteam.dtp.service.DtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Dmitry on 27.10.2017.
 */

@Component
public class hui {

    @Autowired
    DtpService dtpService;

    @Autowired
    DangerousZoneService dangerousZoneService;

    private List<Dtp> dtpList;

    @PostConstruct
    public void generateDangerousZones() {
        dtpList = dtpService.findAll();
        List<Dtp> dtps = new ArrayList<>();
        for (Dtp dtp : dtpList) {
            if (dtp.getDate().getTime() > (System.currentTimeMillis() - 2592000000L)) {
                dtps.add(dtp);
            }
        }
        dtpList = dtps;
        while (!this.dtpList.isEmpty()) {
            double radius = 0.000427917048;
            findRealCenter(this.dtpList.get(0), this.dtpList, radius);
        }
    }

    private void findRealCenter(Dtp currCenter, List<Dtp> crushList, double radius) {
        List<Dtp> dtpInRadius = new ArrayList<>();
        for (Dtp crush : crushList) {
            if (isInRadius(currCenter, crush, radius)) {
                dtpInRadius.add(crush);
            }
        }
        Dtp newCurrCenter = getNewCenter(dtpInRadius);
        if (!Objects.equals(newCurrCenter.getLatitude(), currCenter.getLatitude()) || !Objects.equals(newCurrCenter.getLongitude(), currCenter.getLongitude())) {
            findRealCenter(newCurrCenter, this.dtpList, radius);
        } else {
            this.dtpList.removeAll(dtpInRadius);
            if (dtpInRadius.size() / 30 > 1 / 10) {
                dangerousZoneService.add(new DangerousZones(currCenter.getLatitude(), currCenter.getLongitude(), 50.0));
            }
        }
    }

    private boolean isInRadius(Dtp currCenter, Dtp dtp, double radius) {
        return (((currCenter.getLatitude() - dtp.getLatitude()) * (currCenter.getLatitude() - dtp.getLatitude()) + ((currCenter.getLongitude() - dtp.getLongitude()) * (currCenter.getLongitude() - dtp.getLongitude())) < radius * radius));
    }

    private Dtp getNewCenter(List<Dtp> dtpInRadius) {
        double newLat = 0;
        double newLon = 0;
        for (Dtp dtp : dtpInRadius) {
            newLat = newLat + dtp.getLatitude();
            newLon = newLon + dtp.getLongitude();
        }
        newLat = newLat / dtpInRadius.size();
        newLon = newLon / dtpInRadius.size();
        return new Dtp(newLat, newLon);
    }
}
