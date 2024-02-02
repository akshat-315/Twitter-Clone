package com.project.twitterclone.controller;

import com.project.twitterclone.config.JwtProvider;
import com.project.twitterclone.repository.UserRepository;
import com.project.twitterclone.service.CustomUserDetailsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private CustomUserDetailsServiceImplementation customUserDetails;

}
