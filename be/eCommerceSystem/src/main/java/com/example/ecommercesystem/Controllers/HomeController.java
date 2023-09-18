package com.example.ecommercesystem.Controllers;

import com.example.ecommercesystem.Models.User;
import com.example.ecommercesystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping
public class HomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/home")
    @ResponseBody
    public String index(){
        return "Hello world";
    }

    @GetMapping("/data")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
