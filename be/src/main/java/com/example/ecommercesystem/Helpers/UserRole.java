package com.example.ecommercesystem.Helpers;

public enum UserRole {

    USER(1),
    EDITOR(2),
    CREATOR(3),
    ADMIN(4),
    MANAGER(5);

    public final Integer role;

    UserRole(Integer role){
        this.role = role;
    }

}
