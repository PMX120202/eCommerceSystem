package com.example.ecommercesystem;

import com.example.ecommercesystem.DTO.AuthenticationRequestDTO;
import com.example.ecommercesystem.Models.User;
import com.example.ecommercesystem.Services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class ECommerceSystemApplicationTests {
    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        String email = "user9@gmail.com";
        String password = "user9@";
        User user = userService.authenticateUser(new AuthenticationRequestDTO(email, password));

        System.out.println(user);

        
    }

}
