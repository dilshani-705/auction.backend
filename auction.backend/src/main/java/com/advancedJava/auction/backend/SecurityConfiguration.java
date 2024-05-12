package com.advancedJava.auction.backend;

import com.advancedJava.auction.backend.User.Mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserMapper userMapper(PasswordEncoder passwordEncoder){

        return new UserMapper(passwordEncoder);
    }
}
