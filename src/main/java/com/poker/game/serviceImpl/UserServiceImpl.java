package com.poker.game.serviceImpl;

import com.poker.game.dto.UserDetailsDto;
import com.poker.game.entity.MobileOtpVerification;
import com.poker.game.entity.UserDetails;
import com.poker.game.exception.CustomAppException;
import com.poker.game.repository.MobileRepository;
import com.poker.game.repository.UserRepository;
import com.poker.game.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MobileRepository mobileRepository;

    @Override
    public UserDetails UserRegistration(UserDetailsDto userDto) {
        Optional<UserDetails> existingUser = userRepository.findByMobileNumber(userDto.getMobile());
        if(existingUser.isPresent()){
            throw new CustomAppException("Your's Mobile Number already existing. Please try another number." + userDto.getMobile());
        }
//        sendOtp(userDto.getMobile());
//
//        MobileOtpVerification otpRecord = mobileRepository.findByMobileNumber(userDto.getMobile())
//                .orElseThrow(() -> new CustomAppException("there is no dataFound by given number."));
//        String otpValue = otpRecord.getOtp();
//       boolean ver = verified(userDto.getMobile(), otpValue);
//        if(!ver){
//            throw new CustomAppException("Otp is failed.");
//        }


        //Checking Whether Customer Age is greater than or equal to 18 or not.
        LocalDate todayDate = LocalDate.now();
        LocalDate dob = userDto.getDateOfBirth();
        if(dob.isAfter(todayDate.minusYears(18))){
            throw new CustomAppException("User must be at least 18 years old to register.");
        }

        //Generating the UUID
        String uuid = UUID.randomUUID().toString();
    //    UUID userUuid = UUID.fromString(uuid);
        String cleanUuid = uuid.replace("-", "");
        String loginId = cleanUuid.substring(cleanUuid.length() - 6);


        UserDetails user = new UserDetails();
        user.setUserId(uuid);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setMobileNumber(userDto.getMobile());
        user.setLoginId(loginId);
        user.setPassword(userDto.getPassword());

        return userRepository.save(user);
    }

//    // Storing the otp's in data-base.
//    private void sendOtp(String moblieNumber){
//
//        String otpValue = String.valueOf(100000+ new Random().nextInt(900000));
//
//        MobileOtpVerification otpEntity = mobileRepository.findByMobileNumber(moblieNumber)
//                .orElse(MobileOtpVerification.builder()
//                        .mobileNumber(moblieNumber)
//                        .createdAt(LocalDateTime.now())
//                      //.verified(false)
//                        .build());
//
//        otpEntity.setOtp(otpValue);
//        otpEntity.setVerified(false);
//        otpEntity.setCreatedAt(LocalDateTime.now());
//
//        mobileRepository.save(otpEntity);
//    }
//
//    boolean verified (String moblieNumber, String enteredOtp ){
//
//        MobileOtpVerification otpRecord = mobileRepository.findByMobileNumber(moblieNumber)
//                .orElseThrow(() -> new CustomAppException("No otp found for this number. please request again."));
//        if(!otpRecord.getOtp().equals(enteredOtp)){
//            throw new CustomAppException("Invalid OTP. please try again.");
//        }
//        otpRecord.setVerified(true);
//        mobileRepository.save(otpRecord);
//        return true;
//    }
}
