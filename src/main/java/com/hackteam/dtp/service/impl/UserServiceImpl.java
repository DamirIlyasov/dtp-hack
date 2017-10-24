package com.hackteam.dtp.service.impl;

import com.hackteam.dtp.model.User;
import com.hackteam.dtp.repository.UserRepository;
import com.hackteam.dtp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findOneByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public User findOneByPhone(String phone) {
        return userRepository.findOneByPhone(phone);
    }

    @Override
    public User findOneById(Long id) {
        return userRepository.findOne(id);
    }
}
