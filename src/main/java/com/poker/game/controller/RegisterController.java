package com.poker.game.controller;

import com.poker.game.dto.UserDetailsDto;
import com.poker.game.entity.UserDetails;
import com.poker.game.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")
@CrossOrigin(origins = "https://poker-gamenn.netlify.app")
public class RegisterController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserDetailsDto userDetailsDto){
        UserDetails registerUser = userService.UserRegistration(userDetailsDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registerUser);
    }

    @PostMapping("/test")
    public ResponseEntity<?> test(@RequestBody UserDetailsDto dto) {
        System.out.println("MOBILE RECEIVED: " + dto.getMobile());
        return ResponseEntity.ok(dto);
    }

}
