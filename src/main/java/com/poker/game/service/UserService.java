package com.poker.game.service;

import com.poker.game.dto.UserDetailsDto;
import com.poker.game.entity.UserDetails;

public interface UserService {
    UserDetails UserRegistration (UserDetailsDto userDto);
}
