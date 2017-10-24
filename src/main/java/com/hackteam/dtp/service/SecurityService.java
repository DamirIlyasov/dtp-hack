package com.hackteam.dtp.service;


import com.hackteam.dtp.model.User;

public interface SecurityService {
    User getCurrentUser();

    String getCurrentUsersEmail();

    String generateToken(String email, String password);

}
