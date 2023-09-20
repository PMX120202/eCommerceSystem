package com.example.ecommercesystem.Services;

import com.example.ecommercesystem.Configs.JwtTokenProvider;
import com.example.ecommercesystem.DTO.AuthenticationRequestDTO;
import com.example.ecommercesystem.DTO.RegisterDTO;
import com.example.ecommercesystem.Helpers.UserRole;
import com.example.ecommercesystem.Models.CustomUserDetails;
import com.example.ecommercesystem.Models.Role;
import com.example.ecommercesystem.Models.User;
import com.example.ecommercesystem.Repositories.RoleRepository;
import com.example.ecommercesystem.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        // Kiểm tra xem user có tồn tại trong database không?
        User user = userRepository.findByEmail(username);

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

    public boolean registerUser(RegisterDTO user){
        boolean isExistUser = userRepository.findByEmail(user.getEmail()) != null;

        //If user is exist in database then unregister
        if(isExistUser){
            return false;
        }

        Role userRole = roleRepository.findById(UserRole.USER.role).get();
        Set<Role> listUserRoles = new HashSet<>();
        listUserRoles.add(userRole);

        String encodePassword = passwordEncoder.encode(user.getPassword());

        User currUser = new User();
//        currUser.setId(1);
        currUser.setEmail(user.getEmail());
        currUser.setPassword(encodePassword);
        currUser.setEnabled((byte) 1);
        currUser.setCreateAt(Timestamp.valueOf(LocalDateTime.now()));

        currUser.setRoles(listUserRoles);

        userRepository.save(currUser);

        return true;
    }


    public User authenticateUser(AuthenticationRequestDTO user){
        User currentUser = userRepository.findByEmail(user.getEmail());

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
