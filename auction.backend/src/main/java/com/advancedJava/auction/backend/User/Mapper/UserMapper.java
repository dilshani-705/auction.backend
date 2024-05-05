package com.advancedJava.auction.backend.User.Mapper;

import com.advancedJava.auction.backend.User.Dto.UserDto;
import com.advancedJava.auction.backend.User.Entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserMapper {
    private PasswordEncoder passwordEncoder;
    public UserMapper(PasswordEncoder passwordEncoder) {

        this.passwordEncoder = passwordEncoder;
    }
    public UserDto mapUserToDto(User user) {
        return new UserDto(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.getMobileNo(),
                user.getAddress(),
                user.getRole(),
                user.getPassword()
        );
    }
    public User mapDtoToUser(UserDto userDto) {
        return new  User(
                userDto.getUserId(),
                userDto.getUserName(),
                userDto.getEmail(),
                userDto.getMobileNo(),
                userDto.getAddress(),
                userDto.getRole(),
                userDto.getPassword()

        );
    }
}
