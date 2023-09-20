package com.example.ecommercesystem.Controllers;

import com.example.ecommercesystem.Configs.JwtTokenProvider;
import com.example.ecommercesystem.DTO.*;
import com.example.ecommercesystem.Models.User;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommercesystem.Services.UserService;

import java.sql.Timestamp;

import java.time.LocalDateTime;
import java.util.Set;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private JwtTokenProvider tokenProvider;

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();


    @PostMapping("/login")
    public ResponseEntity<ResponseClient> authenticateUser(@RequestBody AuthenticationRequestDTO loginRequest) {

        //Check information client send
        Set<ConstraintViolation<AuthenticationRequestDTO>> violations = validator.validate(loginRequest);

        if(!violations.isEmpty()){
            for (ConstraintViolation<AuthenticationRequestDTO> violation : violations) {
                return ResponseEntity
                        .badRequest()
                        .body(new ResponseMessage(2, violation.getMessage()));
            }
        }
        //End check information client send


        User authUser = userService.authenticateUser(loginRequest);

        if(authUser != null){
            // Trả về jwt cho người dùng.
            String jwt = tokenProvider.generateToken(authUser);

            AuthenticationResponseDTO
                    authenticationResponseDTO
                    = new AuthenticationResponseDTO(
                            authUser.getEmail(),
                            authUser.getFirstName(),
                            authUser.getLastName(),
                            authUser.getTelephone(),
                            authUser.getAvatar(),
                            jwt
                    );

            return ResponseEntity
                    .ok(authenticationResponseDTO);
        }else {
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessage(1, "Email or password incorrect"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseClient> signup(@RequestBody RegisterDTO registerDTO){

        //Check information client send
        Set<ConstraintViolation<RegisterDTO>> violations = validator.validate(registerDTO);

        if(!violations.isEmpty()){
            for (ConstraintViolation<RegisterDTO> violation : violations) {
                return ResponseEntity
                        .badRequest()
                        .body(new ResponseMessage(2, violation.getMessage()));
            }
        }
        //End check information client send

        //Valid password and confirm password
        String password = registerDTO.getPassword();
        String confirmPassword = registerDTO.getConfirmPassword();

        if(!password.equals(confirmPassword)){
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessage(2, "Password and confirm password not match"));
        }
        //End valid password and confirm password

        boolean isCreateSucceed = userService.registerUser(registerDTO);

        if(!isCreateSucceed){
            return ResponseEntity
                    .badRequest()
                    .body(new ResponseMessage(1, "Please use another email"));
        }

        return ResponseEntity
                .ok(new ResponseMessage(0, "Created successfully"));
    }
}
