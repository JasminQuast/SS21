package com.example.demo;

public class User {

    private final String email;
    private final String username;
    private final String password;

    public User(String email, String name, String pw) {
        this.email = email;
        this.username = name;
        this.password = pw;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
