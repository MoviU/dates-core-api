package com.dates.core_api.controller;

import com.dates.core_api.model.dto.response.AuthResponse;
import com.dates.core_api.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.dates.core_api.model.dto.RegisterUserRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(
            @Valid @RequestBody RegisterUserRequestDto requestDto
            ) {
        String jwt = authService.register(requestDto);

        return ResponseEntity.ok(new AuthResponse(jwt).token());
    }
}

