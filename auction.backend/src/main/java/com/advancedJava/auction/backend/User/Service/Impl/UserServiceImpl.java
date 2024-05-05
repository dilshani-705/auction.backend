package com.advancedJava.auction.backend.User.Service.Impl;

import com.advancedJava.auction.backend.User.Dto.UserDto;
import com.advancedJava.auction.backend.User.Entity.User;
import com.advancedJava.auction.backend.User.Mapper.UserMapper;
import com.advancedJava.auction.backend.User.Repository.UserRepository;
import com.advancedJava.auction.backend.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }


    @Override
    public UserDto getUserById(String userId) throws Exception {
        User user= userRepository.findUserByUserId(userId);
        return userMapper.mapUserToDto(user);

    }


    @Override
    public List<UserDto> getAllUsers() throws Exception {
        UserMapper userMapper = new UserMapper(passwordEncoder);
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::mapUserToDto).collect(Collectors.toList());
    }


    @Override
    public UserDto addUser(UserDto userDto) throws Exception {
       User user= userMapper.mapDtoToUser(userDto);
       User savedUser = userRepository.save(user);
       return userMapper.mapUserToDto(savedUser);
    }



    @Override
    public UserDto updateUser(String id, UserDto updatedUser) throws Exception {
        User user = userRepository.findUserByUserId(id);
        user.setUserName(updatedUser.getUserName());
        user.setEmail(updatedUser.getEmail());
        if (updatedUser.getPassword() != null) {
            user.setPassword(updatedUser.getPassword(), passwordEncoder);
        }
        userRepository.save(user);
        return userMapper.mapUserToDto(user);
    }

    @Override
    public void deleteUser(String id) throws Exception {
        User user=userRepository.findUserByUserId(id);
        userRepository.deleteById(id);
    }


}
