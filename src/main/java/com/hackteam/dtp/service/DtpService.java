package com.hackteam.dtp.service;

import com.hackteam.dtp.model.Dtp;

import java.util.List;

public interface DtpService {
    void save(Dtp dtp);

    List<Dtp> findAllByFinishedFalse();

    List<Dtp> findAllByFinishedTrue();

    Dtp findOneById(Long id);
}
