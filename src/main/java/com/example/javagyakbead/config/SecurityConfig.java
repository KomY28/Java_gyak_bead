package com.example.javagyakbead.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. CSRF kikapcsolása (szükséges a REST API teszteléshez Postman-ból)
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests((requests) -> requests
                        // 2. Publikus oldalak (Belépés nélkül is láthatóak)
                        // Hozzáadtuk a /rest és /api/** útvonalakat is
                        .requestMatchers("/", "/home", "/register/**", "/login",
                                "/database", "/contact", "/diagram", "/rest",
                                "/api/**",
                                "/assets/**", "/css/**", "/js/**", "/images/**").permitAll()

                        // 3. KIZÁRÓLAG ADMIN láthatja az admin felületet
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        // 4. Minden más oldalhoz (pl. /crud, /messages) bejelentkezés szükséges
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login") // Saját login oldal használata
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/", true) // Sikeres belépés után főoldal
                        .failureUrl("/login?error=true") // Hiba esetén paraméter
                        .permitAll()
                )
                .logout((logout) -> logout
                        .logoutSuccessUrl("/login?logout") // Sikeres kijelentkezés után login oldal
                        .permitAll()
                );

        return http.build();
    }

    // AuthenticationManager Bean (Kötelező a Spring Security 6-hoz)
    @Bean
    public static org.springframework.security.authentication.AuthenticationManager authenticationManager(
            org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    // Jelszó titkosító Bean (BCrypt)
    @Bean
    public static org.springframework.security.crypto.password.PasswordEncoder passwordEncoder() {
        return new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    }
}