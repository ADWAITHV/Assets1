package com.asset.demo.config;

import java.time.LocalDateTime;

public class LoginAttempt {
    private int attempts;
    private LocalDateTime banExpiresAt;

    public LoginAttempt() {
        this.attempts = 0;
    }

    public void incrementAttempts() { this.attempts++; }
    public void resetAttempts() { this.attempts = 0; }
    public int getAttempts() { return attempts; }

    public void setBan(long hours) {
        this.banExpiresAt = LocalDateTime.now().plusHours(hours);
    }

    public boolean isBanned() {
        if (banExpiresAt == null) return false;
        if (LocalDateTime.now().isAfter(banExpiresAt)) {
            banExpiresAt = null; // Ban expired
            attempts = 0;
            return false;
        }
        return true;
    }
}



