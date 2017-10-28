package com.hackteam.dtp.service.impl;

import com.hackteam.dtp.model.DangerousZones;
import com.hackteam.dtp.repository.DangerousZoneRepository;
import com.hackteam.dtp.service.DangerousZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Dmitry on 27.10.2017.
 */

@Service
public class DangerousZoneServiceImpl implements DangerousZoneService {

    @Autowired
    DangerousZoneRepository dangerousZoneRepository;

    @Override
    public void add(DangerousZones dangerousZones) {
        dangerousZoneRepository.save(dangerousZones);
    }
}
