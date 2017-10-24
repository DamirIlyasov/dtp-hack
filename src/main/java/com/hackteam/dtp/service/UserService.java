package com.hackteam.dtp.service;


import com.hackteam.dtp.model.User;

public interface UserService {
    void save(User user);

    User findOneByEmail(String email);

    User findOneByPhone(String phone);

    User findOneById(Long id);
}

