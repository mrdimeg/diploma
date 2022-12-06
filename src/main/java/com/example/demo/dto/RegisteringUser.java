package com.example.demo.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class RegisteringUser {
    private String email;
    private String username;
    private String password;
}
