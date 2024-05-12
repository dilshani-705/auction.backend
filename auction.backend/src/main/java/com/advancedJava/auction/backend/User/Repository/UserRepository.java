package com.advancedJava.auction.backend.User.Repository;

import com.advancedJava.auction.backend.User.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@EnableJpaRepositories
@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findUserByUserId(String userId);
    Optional<User> findUserByUserIdAndPassword(String userId, String password);
}
