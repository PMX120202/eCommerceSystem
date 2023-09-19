package com.example.ecommercesystem;

import com.example.ecommercesystem.Models.User;
import com.example.ecommercesystem.Services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class ECommerceSystemApplicationTests {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired private UserService userService;

    @Test
    void contextLoads() {
        String email = "tanhung@gmail.com";
        String encodePassword = passwordEncoder.encode("123456");

        User user = new User();
        user.setUsername(email);
        user.setPassword(encodePassword);

        userService.registerUser(user);
        assert 1 == 1;
    }

}
