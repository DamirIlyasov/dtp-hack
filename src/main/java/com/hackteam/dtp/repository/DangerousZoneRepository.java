package com.hackteam.dtp.repository;

import com.hackteam.dtp.model.DangerousZones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dmitry on 27.10.2017.
 */

@Repository
public interface DangerousZoneRepository extends JpaRepository<DangerousZones, Long> {
}
