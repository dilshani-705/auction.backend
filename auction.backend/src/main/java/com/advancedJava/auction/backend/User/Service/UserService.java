package com.advancedJava.auction.backend.User.Service;

import com.advancedJava.auction.backend.Login.LoginDto;
import com.advancedJava.auction.backend.Login.LoginMessage;
import com.advancedJava.auction.backend.User.Dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto getUserById(String userId)throws Exception;


    List<UserDto> getAllUsers()throws Exception;
    UserDto addUser(UserDto userDto)throws Exception;

    UserDto updateUser(String userId, UserDto updatedUser) throws Exception;

    void deleteUser(String userId)throws Exception;


    LoginMessage login(LoginDto userDto) throws Exception;


}
