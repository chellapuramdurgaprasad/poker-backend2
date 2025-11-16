package com.poker.game.repository;

import com.poker.game.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDetails, Long> {

    Optional<UserDetails> findByMobileNumber(String MobileNumber);

}
