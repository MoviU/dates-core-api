package com.dates.core_api.service;

import com.dates.core_api.model.entity.User;

public interface JwtService {
    String generateToken(User user);
}
