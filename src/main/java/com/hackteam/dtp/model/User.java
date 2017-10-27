package com.hackteam.dtp.model;

import com.hackteam.dtp.model.enums.Role;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User extends AbstractEntity {


    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private String middleName;
    @Email
    private String email;
    private String phone;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String avatarUrl;
    private boolean verified;
    private String verificationCode;
    private int passwordRecoveryCode = 0;
    @OneToMany
    private List<Car> cars;
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
    private String passNumber;
    private Date passGettingDate;
    private String whoGivedPass;
    private String snils;
    private Boolean acceptPersonalDataTreatment;
    @ManyToMany
    private List<Dtp> dtps = new ArrayList<>();

    public String getPassNumber() {
        return passNumber;
    }

    public void setPassNumber(String passNumber) {
        this.passNumber = passNumber;
    }

    public List<Dtp> getDtps() {
        return dtps;
    }

    public void setDtps(List<Dtp> dtps) {
        this.dtps = dtps;
    }

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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public int getPasswordRecoveryCode() {
        return passwordRecoveryCode;
    }

    public void setPasswordRecoveryCode(int passwordRecoveryCode) {
        this.passwordRecoveryCode = passwordRecoveryCode;
    }
}
