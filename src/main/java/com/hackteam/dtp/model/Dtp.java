package com.hackteam.dtp.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Dtp extends AbstractEntity {
    private String fullDtpPlace;
    private Date date;
    @ElementCollection
    private List<String> usersNumbers = new ArrayList<>();
    @ElementCollection
    private List<String> usersCarsNumbers = new ArrayList<>();
    private int carCrashedCount;
    private int victimsNumbers;
    private boolean matherialDamageToTransportExceptAandB;
    private boolean matherialDamagToDifferentThinks;
    private String witnessesFullNameAndAdresses;
    @ManyToMany
    private List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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

    public List<String> getUsersNumbers() {
        return usersNumbers;
    }

    public void setUsersNumbers(List<String> usersNumbers) {
        this.usersNumbers = usersNumbers;
    }

    public List<String> getUsersCarsNumbers() {
        return usersCarsNumbers;
    }

    public void setUsersCarsNumbers(List<String> usersCarsNumbers) {
        this.usersCarsNumbers = usersCarsNumbers;
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
