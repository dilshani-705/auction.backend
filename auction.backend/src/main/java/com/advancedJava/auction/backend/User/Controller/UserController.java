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
    public ResponseEntity<UserDto>updateUser(@PathVariable("userId") String userId, @RequestBody UserDto updatedUser){
        UserDto user = null;
        try {
            user = userService.updateUser(userId, updatedUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(user);
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
