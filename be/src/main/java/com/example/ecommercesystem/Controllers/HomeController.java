package com.example.ecommercesystem.Controllers;

import com.example.ecommercesystem.Models.User;
import com.example.ecommercesystem.Models.UserRole;
import com.example.ecommercesystem.Repositories.UserRepository;
import com.example.ecommercesystem.Repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/api/v1")
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @GetMapping("/home")
    public String index(){
        return "home";
    }

    @GetMapping("/data")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/data-role")
    public List<UserRole> getUserRole(){
        return userRoleRepository.findAll();
    }


}
