package com.hackteam.dtp.repository;

import com.hackteam.dtp.model.Dtp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DtpRepository extends JpaRepository<Dtp, Long> {
    List<Dtp> findAllByFinishedFalse();

    List<Dtp> findAllByFinishedTrue();

    @Query(value = "SELECT * FROM Dtp where date > '27.10.2016'", nativeQuery = true)
    List<Dtp> findAllByDate();
}
