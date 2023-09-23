package com.example.ecommercesystem.Services;

import com.example.ecommercesystem.Models.Role;
import com.example.ecommercesystem.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Role findById(Integer id){
        return roleRepository.findById(id).get();
    }
}
