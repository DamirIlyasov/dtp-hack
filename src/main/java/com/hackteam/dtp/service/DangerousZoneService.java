package com.hackteam.dtp.service;

import com.hackteam.dtp.model.DangerousZones;

import java.util.List;

/**
 * Created by Dmitry on 27.10.2017.
 */
public interface DangerousZoneService {
    void add(DangerousZones dangerousZones);

    List<DangerousZones> getAll();
}
