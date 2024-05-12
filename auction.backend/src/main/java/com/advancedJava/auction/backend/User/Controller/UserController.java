package com.advancedJava.auction.backend.User.Controller;

import com.advancedJava.auction.backend.Login.LoginDto;
import com.advancedJava.auction.backend.Login.LoginMessage;
import com.advancedJava.auction.backend.User.Dto.ResponseTypeEnum;
import com.advancedJava.auction.backend.User.Dto.UserDto;
import com.advancedJava.auction.backend.User.Entity.User;
import com.advancedJava.auction.backend.User.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private  UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto) throws Exception {
        LoginMessage loginMessage =userService.login(loginDto);
        return ResponseEntity.ok(loginMessage);
    }

    @PostMapping("/add")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto){
        UserDto savedUser = null;
        try {
            savedUser = userService.addUser(userDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>>geAllUsers(){
        List<UserDto> users = null;
        try {
            users = userService.getAllUsers();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(users);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto>getUserById(@PathVariable("userId") String userId){
        UserDto user = null;
        try {
            user = userService.getUserById(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(user);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto>updateUser(@PathVariable("userId") String user_Id, @RequestBody UserDto updatedUser) throws Exception {
        logger.info("Updating user with ID: " + user_Id);
        logger.info("New user data: " + updatedUser.toString());

        try {
            UserDto userDto = userService.updateUser(user_Id, updatedUser);
            return ResponseEntity.ok(userDto);
        } catch (Exception e) {
            logger.error("Error updating user: ", e);
            throw new RuntimeException(e);
        }

    }
    @DeleteMapping("/{userId}")
    public ResponseEntity<String>deleteUser(@PathVariable("userId") String userId){
        try {
            userService.deleteUser(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("User deleted successfully");
    }

}
