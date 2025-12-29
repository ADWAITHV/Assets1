package com.asset.demo.service;

import com.asset.demo.config.LoginAttempt;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service

public class BruteForceService {
    private final int MAX_ATTEMPTS = 5;
    private final ConcurrentHashMap<String, LoginAttempt> attemptsCache = new ConcurrentHashMap<>();

    public boolean isBlocked(String ip) {
        LoginAttempt attempt = attemptsCache.get(ip);
        return attempt != null && attempt.isBanned();
    }

    public void loginFailed(String ip) {
        LoginAttempt attempt = attemptsCache.computeIfAbsent(ip, k -> new LoginAttempt());
        attempt.incrementAttempts();
        if (attempt.getAttempts() >= MAX_ATTEMPTS) {
            attempt.setBan(24);
        }
    }

    public void loginSucceeded(String ip) {
        attemptsCache.remove(ip);
    }
}



