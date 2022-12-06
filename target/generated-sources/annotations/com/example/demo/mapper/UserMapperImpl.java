package com.example.demo.mapper;

import com.example.demo.dto.RegisteringUser;
import com.example.demo.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-12-06T11:04:23+0300",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User fromUserSignupDTO(RegisteringUser registeringUser) {
        if ( registeringUser == null ) {
            return null;
        }

        User.UserBuilder<?, ?> user = User.builder();

        user.password( registeringUser.getPassword() );
        user.username( registeringUser.getUsername() );

        return user.build();
    }
}
