package com.hackteam.dtp.service.impl;

import com.hackteam.dtp.model.Dtp;
import com.hackteam.dtp.repository.DtpRepository;
import com.hackteam.dtp.service.DtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DtpServiceImpl implements DtpService {
    @Autowired
    DtpRepository dtpRepository;

    @Override
    public void save(Dtp dtp) {
        dtpRepository.save(dtp);
    }

    @Override
    public List<Dtp> getLast() {
        List<Dtp> dtps = dtpRepository.findAll();
        List<Dtp> lastDtps = new ArrayList<>();
        for (Dtp dtp : dtps) {
            if (dtp.getDate().getTime() > System.currentTimeMillis() - 7200000L) {
                lastDtps.add(dtp);
            }
        }
        return lastDtps;
    }

    @Override
    public List<Dtp> findAllByFinishedFalse() {
        return dtpRepository.findAllByFinishedFalse();
    }

    @Override
    public List<Dtp> findAllByFinishedTrue() {
        return dtpRepository.findAllByFinishedTrue();
    }

    @Override
    public List<Dtp> getAll() {
        return dtpRepository.findAll();
    }

    @Override
    public List<Dtp> findAll() {
//        long l = 2592000000L;
        return dtpRepository.findAll();
    }

    @Override
    public Dtp findOneById(Long id) {
        return dtpRepository.findOne(id);
    }
}
