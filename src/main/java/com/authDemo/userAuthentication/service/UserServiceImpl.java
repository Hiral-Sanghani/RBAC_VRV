package com.authDemo.userAuthentication.service;

import com.authDemo.userAuthentication.Repository.RoleRepository;
import com.authDemo.userAuthentication.Repository.UserRepository;
import com.authDemo.userAuthentication.dto.UserDto;
import com.authDemo.userAuthentication.model.Role;
import com.authDemo.userAuthentication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN").get();
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles((Set<Role>) Arrays.asList(role));
        System.out.println("User ==. " + user);
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
            .map((user) -> mapToUserDto(user))
            .collect(Collectors.toList());
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        String[] str = user.getName().split(" ");
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        System.out.println("ROleee ---  ");
        role.setName("ROLE_ADMIN");
        System.out.println("------- " + role.getName());
        return roleRepository.save(role);
    }
}
