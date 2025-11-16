package com.poker.game.dto;

import java.util.Objects;

public class OtpDto {

    private String mobile;
    private String otp;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }


    @Override
    public String toString() {
        return "OtpDto{" +
                "mobileNumber='" + mobile + '\'' +
                ", otpValue='" + otp + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OtpDto otpDto = (OtpDto) o;
        return Objects.equals(mobile, otpDto.mobile) && Objects.equals(otp, otpDto.otp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobile, otp);
    }

    public OtpDto(String mobileNumber, String otpValue) {
        this.mobile = mobileNumber;
        this.otp = otpValue;
    }
}
