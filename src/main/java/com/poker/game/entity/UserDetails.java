package com.poker.game.entity;

import jakarta.persistence.*;
import jakarta.websocket.Decoder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@IdClass(UserIdPk.class)
public class UserDetails {

    @Id
    @Column(name = "user_Id", nullable = false)
    private String userId;

    @Id
    @Column(name = "mobile_number", nullable = false)
    private String mobileNumber;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "login_id", nullable = false)
    private String loginId;

    @Column(name = "password", nullable = false)
    private String password;

}
