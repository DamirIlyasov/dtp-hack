package com.hackteam.dtp.service.impl;

import com.hackteam.dtp.model.Dtp;
import com.hackteam.dtp.repository.DtpRepository;
import com.hackteam.dtp.service.DtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Dtp> findAllByFinishedFalse() {
        return dtpRepository.findAllByFinishedFalse();
    }

    @Override
    public List<Dtp> findAllByFinishedTrue() {
        return dtpRepository.findAllByFinishedTrue();
    }

    @Override
    public Dtp findOneById(Long id) {
        return dtpRepository.findOne(id);
    }
}
