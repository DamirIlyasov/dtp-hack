package com.hackteam.dtp.repository;

import com.hackteam.dtp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findOneByEmail(String email);

    User findOneByPhone(String phone);


}
