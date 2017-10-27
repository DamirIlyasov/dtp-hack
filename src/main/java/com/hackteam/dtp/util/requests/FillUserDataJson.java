package com.hackteam.dtp.util.requests;

import java.util.Date;

public class FillUserDataJson {
    private String licenseSerial;
    private String licenseNumber;
    private String inn;
    private String gender;
    private Date birthday;
    private String birthPlace;
    private String registrationAdress;
    private String citizenship;
    private String drivingExperience;
    private String passSeria;
    private Date passGettingDate;
    private String whoGivedPass;
    private String snils;
    private Boolean acceptPersonalDataTreatment;

    public String getLicenseSerial() {
        return licenseSerial;
    }

    public void setLicenseSerial(String licenseSerial) {
        this.licenseSerial = licenseSerial;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getRegistrationAdress() {
        return registrationAdress;
    }

    public void setRegistrationAdress(String registrationAdress) {
        this.registrationAdress = registrationAdress;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getDrivingExperience() {
        return drivingExperience;
    }

    public void setDrivingExperience(String drivingExperience) {
        this.drivingExperience = drivingExperience;
    }

    public String getPassSeria() {
        return passSeria;
    }

    public void setPassSeria(String passSeria) {
        this.passSeria = passSeria;
    }

    public Date getPassGettingDate() {
        return passGettingDate;
    }

    public void setPassGettingDate(Date passGettingDate) {
        this.passGettingDate = passGettingDate;
    }

    public String getWhoGivedPass() {
        return whoGivedPass;
    }

    public void setWhoGivedPass(String whoGivedPass) {
        this.whoGivedPass = whoGivedPass;
    }

    public String getSnils() {
        return snils;
    }

    public void setSnils(String snils) {
        this.snils = snils;
    }

    public Boolean getAcceptPersonalDataTreatment() {
        return acceptPersonalDataTreatment;
    }

    public void setAcceptPersonalDataTreatment(Boolean acceptPersonalDataTreatment) {
        this.acceptPersonalDataTreatment = acceptPersonalDataTreatment;
    }
}
