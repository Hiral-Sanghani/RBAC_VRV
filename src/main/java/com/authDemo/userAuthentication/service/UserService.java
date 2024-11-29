package com.authDemo.userAuthentication.service;

import com.authDemo.userAuthentication.dto.UserDto;
import com.authDemo.userAuthentication.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(UserDto userDto);

    Optional<User> findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
