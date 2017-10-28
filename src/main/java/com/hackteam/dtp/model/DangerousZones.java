package com.hackteam.dtp.model;

import javax.persistence.Entity;

/**
 * Created by Dmitry on 27.10.2017.
 */

@Entity
public class DangerousZones extends AbstractEntity {

    private Double latitude;

    private Double longitude;

    private Double radius;

    public DangerousZones(Double latitude, Double longitude, Double radius) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public DangerousZones() {
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
