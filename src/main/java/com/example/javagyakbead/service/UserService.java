package com.example.javagyakbead.service;

import com.example.javagyakbead.dto.UserDto;
import com.example.javagyakbead.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);
    User findUserByEmail(String email);
}
