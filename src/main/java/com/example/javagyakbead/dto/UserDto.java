package com.example.javagyakbead.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserDto {

    private Long id;

    @NotEmpty(message = "A név nem lehet üres")
    private String name;

    @NotEmpty(message = "Az email nem lehet üres")
    @Email(message = "Érvényes email címet adjon meg")
    private String email;

    @NotEmpty(message = "A jelszó nem lehet üres")
    private String password;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
