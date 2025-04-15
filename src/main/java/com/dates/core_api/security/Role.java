package com.dates.core_api.security;

// TODO
public enum Role {
    USER,
    ADMIN;

    public String getSecurityName() {
        return "ROLE_%s".formatted(this.name());
    }
}
