package com.example.menu.user;

public record UserRequestDTO ( String login, String password, String email, String firstName, String lastName, UserRole role ) {
    
}
