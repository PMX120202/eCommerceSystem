package com.example.ecommercesystem.Services;

import com.example.ecommercesystem.Configs.JwtTokenProvider;
import com.example.ecommercesystem.DTO.AuthenticationRequestDTO;
import com.example.ecommercesystem.Models.CustomUserDetails;
import com.example.ecommercesystem.Models.User;
import com.example.ecommercesystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        return new CustomUserDetails(user);
    }

    public UserDetails loadUserById(Long id){
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findById(id).get();

        if (user == null) {
            throw new UsernameNotFoundException("Not found user with id: " + id.toString());
        }

        return new CustomUserDetails(user);
    }

    public User registerUser(User user){
        return userRepository.save(user);
    }


    public User authenticateUser(AuthenticationRequestDTO user){
        User currentUser = userRepository.findByUsername(user.getEmail());

        if(currentUser != null){
            String rawPassword = user.getPassword();
            String encodePassword = currentUser.getPassword();

            if (passwordEncoder.matches(rawPassword, encodePassword)){
                return currentUser;
            }
        }

        return null;
    }
}
