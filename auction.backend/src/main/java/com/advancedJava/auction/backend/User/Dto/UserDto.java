package com.advancedJava.auction.backend.User.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String userId;
    private String userName;
    private String email;
    private String address;
    private String mobileNo;
    private String role;
    private String password;


}
