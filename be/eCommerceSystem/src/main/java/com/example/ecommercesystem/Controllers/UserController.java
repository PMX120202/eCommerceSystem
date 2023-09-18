package com.example.ecommercesystem.Controllers;

import com.example.ecommercesystem.Configs.JwtTokenProvider;
import com.example.ecommercesystem.DTO.AuthenticationRequestDTO;
import com.example.ecommercesystem.DTO.AuthenticationResponseDTO;
import com.example.ecommercesystem.DTO.RegisterDTO;
import com.example.ecommercesystem.Models.CustomUserDetails;
import com.example.ecommercesystem.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommercesystem.Services.UserService;


@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> authenticateUser(@RequestBody AuthenticationRequestDTO loginRequest) {

//        // Xác thực từ username và password.
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            loginRequest.getEmail(),
//                            loginRequest.getPassword()
//                    )
//            );
//
//            // Nếu không xảy ra exception tức là thông tin hợp lệ
//            // Set thông tin authentication vào Security Context
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            // Trả về jwt cho người dùng.
//            String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
//
//            AuthenticationResponseDTO authenticationResponseDTO = new AuthenticationResponseDTO(loginRequest.getEmail(), jwt);
//
//            return ResponseEntity.ok(authenticationResponseDTO);
//        }catch (Exception exception){
//            return ResponseEntity.status(401).body(new AuthenticationResponseDTO());
//        }

        User authUser = userService.authenticateUser(loginRequest);

        if(authUser != null){
            // Trả về jwt cho người dùng.
            String jwt = tokenProvider.generateToken(authUser);

            AuthenticationResponseDTO authenticationResponseDTO = new AuthenticationResponseDTO(loginRequest.getEmail(), jwt);

            return ResponseEntity.ok(authenticationResponseDTO);
        }else {

        }

        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody RegisterDTO registerDTO){
        String encodePassword = passwordEncoder.encode(registerDTO.getPassword());

        User user = new User();
        user.setUsername(registerDTO.getEmail());
        user.setPassword(encodePassword);

        userService.registerUser(user);

        return ResponseEntity.ok("Create OK");
    }
}
