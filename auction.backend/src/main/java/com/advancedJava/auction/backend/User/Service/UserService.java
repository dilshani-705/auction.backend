package com.advancedJava.auction.backend.User.Service;

import com.advancedJava.auction.backend.User.Dto.UserDto;
import com.advancedJava.auction.backend.User.Entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto getUserById(String userId)throws Exception;


    List<UserDto> getAllUsers()throws Exception;
    UserDto addUser(UserDto userDto)throws Exception;

    UserDto updateUser(String userId, UserDto updatedUser) throws Exception;

    void deleteUser(String userId)throws Exception;


}
