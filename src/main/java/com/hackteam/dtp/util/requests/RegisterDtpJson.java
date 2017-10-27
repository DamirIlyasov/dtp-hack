package com.hackteam.dtp.util.requests;

import java.util.Date;

public class RegisterDtpJson {
    private String fullDtpPlace;
    private Date date;
    private int carCrashedCount;
    private int victimsNumbers;
    private boolean matherialDamageToTransportExceptAandB;
    private boolean matherialDamagToDifferentThinks;
    private String witnessesFullNameAndAdresses;
    private Double latitude;
    private Double longitude;

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

    public String getFullDtpPlace() {
        return fullDtpPlace;
    }

    public void setFullDtpPlace(String fullDtpPlace) {
        this.fullDtpPlace = fullDtpPlace;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCarCrashedCount() {
        return carCrashedCount;
    }

    public void setCarCrashedCount(int carCrashedCount) {
        this.carCrashedCount = carCrashedCount;
    }

    public int getVictimsNumbers() {
        return victimsNumbers;
    }

    public void setVictimsNumbers(int victimsNumbers) {
        this.victimsNumbers = victimsNumbers;
    }

    public boolean isMatherialDamageToTransportExceptAandB() {
        return matherialDamageToTransportExceptAandB;
    }

    public void setMatherialDamageToTransportExceptAandB(boolean matherialDamageToTransportExceptAandB) {
        this.matherialDamageToTransportExceptAandB = matherialDamageToTransportExceptAandB;
    }

    public boolean isMatherialDamagToDifferentThinks() {
        return matherialDamagToDifferentThinks;
    }

    public void setMatherialDamagToDifferentThinks(boolean matherialDamagToDifferentThinks) {
        this.matherialDamagToDifferentThinks = matherialDamagToDifferentThinks;
    }

    public String getWitnessesFullNameAndAdresses() {
        return witnessesFullNameAndAdresses;
    }

    public void setWitnessesFullNameAndAdresses(String witnessesFullNameAndAdresses) {
        this.witnessesFullNameAndAdresses = witnessesFullNameAndAdresses;
    }
}
