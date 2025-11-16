package com.poker.game.controller;

import com.poker.game.dto.OtpDto;
import com.poker.game.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://poker-gamenn.netlify.app")
@RestController
@RequestMapping("/v1/otp")
public class OtpController {

    @Autowired
    private OtpService otpService;

    @PostMapping("/send")
    public ResponseEntity<?> sendOtp (@RequestBody OtpDto requestDto){
        otpService.sendOtp(requestDto);
        return ResponseEntity.ok("OTP Sent successfully");
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verifyOtp (@RequestBody OtpDto requestDto){
        otpService.verifyOtp(requestDto);
        return ResponseEntity.ok("OTP verified successfully");
    }


}
