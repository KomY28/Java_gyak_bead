package com.example.javagyakbead.controller;

import com.example.javagyakbead.dto.UserDto;
import com.example.javagyakbead.entity.User;
import com.example.javagyakbead.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Regisztrációs űrlap megjelenítése
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // Regisztrációs adatok feldolgozása
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        // Ellenőrizzük, van-e már ilyen email
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "Ezzel az email címmel már létezik fiók!");
        }

        // Ha hiba van az űrlapon (pl. üres mező), visszaküldjük javításra
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "register";
        }

        // Ha minden oké, mentés és irány a login oldal
        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    // Bejelentkezés oldal
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}