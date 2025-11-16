package com.poker.game.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class UserIdPk implements Serializable {

    private String userId;
    private String mobileNumber;

// getter and setter.
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    // hash code and equal's
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserIdPk userIdPk = (UserIdPk) o;
        return Objects.equals(userId, userIdPk.userId) && Objects.equals(mobileNumber, userIdPk.mobileNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(userId, mobileNumber);
    }
    //Constructor.
    public UserIdPk() { }
}
