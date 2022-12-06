package com.example.demo.mapper;

import com.example.demo.dto.RegisteringUser;
import com.example.demo.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User fromUserSignupDTO(RegisteringUser registeringUser);

}
