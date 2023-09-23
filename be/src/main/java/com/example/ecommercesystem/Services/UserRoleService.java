package com.example.ecommercesystem.Services;

import com.example.ecommercesystem.Helpers.UserRoleHelper;
import com.example.ecommercesystem.Models.User;
import com.example.ecommercesystem.Models.UserRole;
import com.example.ecommercesystem.Repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleService roleService;

    public UserRole findById(Integer id){
        return userRoleRepository.findById(id).get();
    }

    public UserRole save(UserRole userRole){
        return userRoleRepository.save(userRole);
    }

    public UserRole saveRoleUserForUser(User user){
        UserRole userRole = new UserRole();
        userRole.setUser(user);
        userRole.setRole(roleService.findById(UserRoleHelper.USER.role));

        return userRoleRepository.save(userRole);
    }

    public List<Optional<UserRole>> findByUser(User user){
        return userRoleRepository.findByUser(user);
    }
}
