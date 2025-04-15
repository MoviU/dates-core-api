package com.dates.core_api.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    private String secret;
    private int expirationInMinutes;

    public long getExpirationInMilliseconds() {
        return (long) expirationInMinutes * 1000;
    }
}
