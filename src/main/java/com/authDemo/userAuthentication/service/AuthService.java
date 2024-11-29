package com.authDemo.userAuthentication.service;

import com.authDemo.userAuthentication.dto.LoginDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    String login(LoginDto loginDto);
}
