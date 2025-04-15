package com.dates.core_api.service;

import com.dates.core_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import com.dates.core_api.model.dto.RegisterUserRequestDto;
import com.dates.core_api.model.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private UserRepository repository;
    private JwtService jwtService;

    @Override
    public String register(RegisterUserRequestDto requestDto) {
        User user = new User();

        user.setEmail(requestDto.email());
        user.setPhoneNumber(requestDto.phoneNumber());

        user.setPassword(passwordEncoder.encode(requestDto.password()));

        repository.save(user);

        return jwtService.generateToken(user);
    }
}
