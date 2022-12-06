package com.example.demo.controller;

import com.example.demo.dto.UserLoginDTO;
import com.example.demo.dto.RegisteringUser;
import com.example.demo.service.UserService;
import io.swagger.annotations.*;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Locale;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    public static final String MESSAGE_PROPERTY_USER_NOT_FOUND = "entity.user.notfound";
    public static final String MESSAGE_PROPERTY_USER_REGISTERED = "entity.user.registered";
    public static final String MESSAGE_PROPERTY_USER_EXISTS = "entity.user.exists";
    private final UserService userService;
    private final MessageSource messageSource;

    public UserController(UserService userService, MessageSource messageSource) {
        this.userService = userService;
        this.messageSource = messageSource;
    }

    @PostMapping("/signup")
    @ApiOperation(value = "Method allows a user to register")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "User successfully registered!"),
            @ApiResponse(code = 400, message = "User already exists!")
    })
    public ResponseEntity<Object> signup(@RequestBody RegisteringUser registeringUser, Locale locale) {
        ResponseEntity<Object> responseEntity;
        if (userService.signup(registeringUser).isPresent()) {
            responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(messageSource
                    .getMessage(new DefaultMessageSourceResolvable(MESSAGE_PROPERTY_USER_REGISTERED), locale));
        } else {
            responseEntity =  ResponseEntity.badRequest().body(messageSource
                    .getMessage(new DefaultMessageSourceResolvable(MESSAGE_PROPERTY_USER_EXISTS), locale));
        }
        return responseEntity;
    }

    @PostMapping("/login")
    @ApiOperation(value = "Method allows a user to log in")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "JWT token"),
            @ApiResponse(code = 404, message = "User not found!")
    })
    public ResponseEntity<Object> login(@RequestBody UserLoginDTO userLoginDTO, Locale locale) {
        ResponseEntity<Object> responseEntity;
        if (userService.login(userLoginDTO)) {
            responseEntity = ResponseEntity.ok(userService.generateToken(userLoginDTO));
        } else {
            responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageSource
                    .getMessage(new DefaultMessageSourceResolvable(MESSAGE_PROPERTY_USER_NOT_FOUND), locale));
        }
        return responseEntity;
    }

    @GetMapping("/test")
    public ResponseEntity<Object> log() {
        return ResponseEntity.ok().build();
    }
}
