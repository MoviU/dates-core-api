package com.dates.core_api.service;

import com.dates.core_api.model.dto.RegisterUserRequestDto;

public interface AuthService {
    String register(RegisterUserRequestDto registerUserDto);
}
