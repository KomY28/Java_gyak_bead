package com.example.javagyakbead;

import com.example.javagyakbead.entity.Role;
import com.example.javagyakbead.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaGyakBeadApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaGyakBeadApplication.class, args);
    }

    @Bean
    public CommandLineRunner initRoles(RoleRepository roleRepository) {
        return args -> {
            // Ha még nincs ROLE_ADMIN, hozzuk létre
            if (roleRepository.findByName("ROLE_ADMIN") == null) {
                roleRepository.save(new Role("ROLE_ADMIN"));
            }
            // Ha még nincs ROLE_USER, hozzuk létre (ez lesz a regisztrált látogató)
            if (roleRepository.findByName("ROLE_USER") == null) {
                roleRepository.save(new Role("ROLE_USER"));
            }
        };
    }
}