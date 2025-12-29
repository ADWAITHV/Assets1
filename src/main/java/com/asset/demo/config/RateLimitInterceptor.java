package com.asset.demo.config;

import com.asset.demo.service.BruteForceService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RateLimitInterceptor implements HandlerInterceptor {
    private final BruteForceService bruteForceService;

    public RateLimitInterceptor(BruteForceService bruteForceService) {
        this.bruteForceService = bruteForceService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = request.getRemoteAddr();
        if (bruteForceService.isBlocked(ip)) {
            response.setStatus(429);
            response.getWriter().write("Too Many Requests - IP Banned for 24 Hours");
            return false;
        }
        return true;
    }
}


