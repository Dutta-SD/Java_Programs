package org.local.easybank.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain makeProjectSecurityConfig(HttpSecurity http) throws Exception {
        return http
                .cors(AbstractHttpConfigurer::disable) // TODO: Change using Bean
                .csrf(csrf -> csrf.ignoringRequestMatchers("/contact", "/notices"))
                .authorizeHttpRequests(auth -> auth.requestMatchers("/account/**", "/balance/**")
                        .authenticated()
                        .requestMatchers("/contact", "/notices", "/register")
                        .permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        // TODO: Make non null
        return null;
    }
}