package com.hackteam.dtp.dto;

import java.util.Date;

public class DtpDto {
    private Long id;
    private String fullDtpPlace;
    private Date date;
    private int carCrashedCount;
    private int victimsNumbers;
    private boolean matherialDamageToTransportExceptAandB;
    private boolean matherialDamagToDifferentThinks;
    private String witnessesFullNameAndAdresses;
    private boolean finished = false;
    private Double latitude;
    private Double longitude;
    private UserDto firstUser;
    private UserDto secondUser;
    private CarDto firstCar;
    private CarDto secondCar;
    private String firstUsersName;
    private String secondUsersName;

    public CarDto getFirstCar() {
        return firstCar;
    }

    public void setFirstCar(CarDto firstCar) {
        this.firstCar = firstCar;
    }

    public CarDto getSecondCar() {
        return secondCar;
    }

    public void setSecondCar(CarDto secondCar) {
        this.secondCar = secondCar;
    }

    public String getFirstUsersName() {
        return firstUsersName;
    }

    public void setFirstUsersName(String firstUsersName) {
        this.firstUsersName = firstUsersName;
    }

    public String getSecondUsersName() {
        return secondUsersName;
    }

    public void setSecondUsersName(String secondUsersName) {
        this.secondUsersName = secondUsersName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
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

    public UserDto getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(UserDto firstUser) {
        this.firstUser = firstUser;
    }

    public UserDto getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(UserDto secondUser) {
        this.secondUser = secondUser;
    }
}
