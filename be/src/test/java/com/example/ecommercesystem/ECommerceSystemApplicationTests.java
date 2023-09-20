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

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

    }

}
