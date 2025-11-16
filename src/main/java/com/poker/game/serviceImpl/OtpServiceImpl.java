package com.poker.game.serviceImpl;

import com.poker.game.dto.OtpDto;
import com.poker.game.entity.MobileOtpVerification;
import com.poker.game.exception.CustomAppException;
import com.poker.game.repository.MobileRepository;
import com.poker.game.service.OtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class OtpServiceImpl implements OtpService {

    @Autowired
    private MobileRepository mobileRepository;


    @Override
    public void sendOtp(OtpDto otpDto) {

        String mobileNumber = otpDto.getMobile();

        Optional<MobileOtpVerification> verifyNumber = mobileRepository.findByMobileNumber(mobileNumber);

        if(verifyNumber.isPresent()){
            throw new CustomAppException("Mobile Number already exit's");
        }

        //Generate UUID.
        String uuid = UUID.randomUUID().toString();

        //Send OTP.
        String otpValue = String.valueOf(100000+ new Random().nextInt(900000));

        MobileOtpVerification otpRecord = new MobileOtpVerification();
        otpRecord.setId(uuid);
        otpRecord.setMobileNumber(mobileNumber);
        otpRecord.setOtp(otpValue);
        otpRecord.setVerified(false);
        otpRecord.setCreatedAt(LocalDateTime.now());

        mobileRepository.save(otpRecord);

        // temporary until SMS integration
        System.out.println("✅ OTP sent to " + mobileNumber + ": " + otpValue);

    }

    @Override
    public void verifyOtp(OtpDto otpDto) {
        MobileOtpVerification otpRecord = mobileRepository.findByMobileNumber(otpDto.getMobile())
                .orElseThrow(() -> new CustomAppException("Mobile Number Doesn't Exit's => please request again the OTP"));

        if (!otpRecord.getOtp().equals(otpDto.getOtp())) {
            throw new CustomAppException("Invalid OTP. Try again.");
        }

        otpRecord.setVerified(true);
        mobileRepository.save(otpRecord);

    }
}

