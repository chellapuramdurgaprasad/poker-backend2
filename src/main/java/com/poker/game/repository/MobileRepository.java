package com.poker.game.repository;

import com.poker.game.entity.MobileOtpVerification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MobileRepository extends JpaRepository<MobileOtpVerification, Long> {

    Optional<MobileOtpVerification> findByMobileNumber(String MobileNumber);


}
