package com.hackteam.dtp.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Dtp extends AbstractEntity {
    @Override
    public String toString() {
        return "Dtp{" +
                "fullDtpPlace='" + fullDtpPlace + '\'' +
                ", date=" + date +
                ", carCrashedCount=" + carCrashedCount +
                ", victimsNumbers=" + victimsNumbers +
                ", matherialDamageToTransportExceptAandB=" + matherialDamageToTransportExceptAandB +
                ", matherialDamagToDifferentThinks=" + matherialDamagToDifferentThinks +
                ", witnessesFullNameAndAdresses='" + witnessesFullNameAndAdresses + '\'' +
                ", finished=" + finished +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", firstUser=" + firstUser +
                ", secondUser=" + secondUser +
                ", firstCar=" + firstCar +
                ", secondCar=" + secondCar +
                '}';
    }

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
    @ManyToOne
    private User firstUser;
    @ManyToOne
    private User secondUser;

    @ManyToOne
    private Car firstCar;
    @ManyToOne
    private Car secondCar;


    public Car getFirstCar() {
        return firstCar;
    }

    public void setFirstCar(Car firstCar) {
        this.firstCar = firstCar;
    }

    public Car getSecondCar() {
        return secondCar;
    }

    public void setSecondCar(Car secondCar) {
        this.secondCar = secondCar;
    }

    public User getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(User firstUser) {
        this.firstUser = firstUser;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
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

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
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

    public Dtp(Date date, Double latitude, Double longitude) {
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Dtp() {

    }

    public Dtp(Double latitude, Double longitude) {

        this.latitude = latitude;
        this.longitude = longitude;
    }
}
