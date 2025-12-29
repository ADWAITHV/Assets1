package com.asset.demo.controller;



import com.asset.demo.service.BruteForceService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/api")
public class LoginController {


    private final BruteForceService bruteForceService;

    public LoginController(BruteForceService bruteForceService) {
        this.bruteForceService = bruteForceService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
        String ip = request.getRemoteAddr();

        if ("adwaith".equals(username) && "adwaith4431".equals(password)) {
            bruteForceService.loginSucceeded(ip);
            return "Login Successful";
        } else {
            bruteForceService.loginFailed(ip);
            return "Invalid Credentials";
        }
    }
}








