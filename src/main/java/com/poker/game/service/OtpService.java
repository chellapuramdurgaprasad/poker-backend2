package com.poker.game.service;

import com.poker.game.dto.OtpDto;

public interface OtpService {
   void sendOtp(OtpDto otpDto);
   void verifyOtp(OtpDto otpDto);
}
