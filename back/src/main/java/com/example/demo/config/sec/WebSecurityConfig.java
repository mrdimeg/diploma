package com.example.demo.config.sec;

import com.example.demo.config.sec.jwt.JwtConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Value("${security.endpoint.permit.all}")
    private String[] permitAllEndpointPatterns;
    @Value("${security.swagger.endpoint.permit.all}")
    private String[] permitAllSwaggerEndpointPatterns;
    private final JwtConfiguration jwtConfiguration;

    public WebSecurityConfig(JwtConfiguration jwtConfiguration) {
        this.jwtConfiguration = jwtConfiguration;
    }

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeRequests()
                    .antMatchers(permitAllEndpointPatterns).permitAll()
                    .antMatchers(permitAllSwaggerEndpointPatterns).permitAll()
                    .anyRequest().authenticated()
                    .and()
                .apply(jwtConfiguration)
                    .and()
                .headers().frameOptions().disable()
                    .and()
                .build();
    }
}
