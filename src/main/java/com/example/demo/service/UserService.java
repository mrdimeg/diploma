package com.example.demo.service;

import com.example.demo.config.sec.jwt.JwtProvider;
import com.example.demo.dto.RegisteringUser;
import com.example.demo.dto.UserLoginDTO;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {
    @Value("${security.role.user}")
    private String ROLE_USER;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, UserMapper userMapper,
                       PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager,
                       JwtProvider jwtProvider) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    public Optional<User> signup(RegisteringUser registeringUser) {
        Optional<User> registeredUser = Optional.empty();
        if (!userRepository.existsByUsername(registeringUser.getUsername())) {
            User user = userMapper.fromUserSignupDTO(registeringUser);
            Set<Role> roles = new HashSet<>() {{
                add(roleRepository.findByName(ROLE_USER).orElse(null));
            }};
            user.setRoles(roles);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            registeredUser = Optional.of(userRepository.save(user));
        }
        return registeredUser;
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginDTO.getUsername(),
                    userLoginDTO.getPassword()));
            return true;
        } catch (AuthenticationException authenticationException) {
            return false;
        }
    }

    public String generateToken(UserLoginDTO userLoginDTO) {
        Optional<User> user = userRepository.findByUsername(userLoginDTO.getUsername());
        String token = null;
        if (user.isPresent()) {
            token = jwtProvider.generateJWT(user.get().getUsername(), user.get().getRoles());
        }
        return token;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
