package com.advancedJava.auction.backend.User.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Entity
@Table(name= "user")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private String userId;
    @Column(name = "name")
    private String userName;
    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String  address;

    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name="role")
    private String role;
    @Column(name = "password")
    private String password;

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password, PasswordEncoder passwordEncoder) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
