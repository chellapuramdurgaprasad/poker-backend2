package com.poker.game.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="mobile_otp_verification")
public class MobileOtpVerification {

    @Id
    @Column(name = "otp_Id", nullable = false)
    private String id;

    @Column(name = "mobile_number", nullable = false, unique = true)
    private String mobileNumber;

    @Column(name="otp", nullable = false)
    private String otp;

    @Column(name="verified", nullable = false)
    private boolean verified = false;

    @Column(name="createdAt", nullable = false)
    private LocalDateTime createdAt;

}
