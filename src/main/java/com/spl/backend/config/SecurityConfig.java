package com.spl.backend.config;

import com.spl.backend.security.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
public class SecurityConfig {
    private JwtAuthFilter jwtAuthFilter;


    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        return httpSecurity.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth-> auth.
                        requestMatchers("/auth/**","/swagger-ui/**","/v3/api-docs/**").permitAll()
                        .requestMatchers(HttpMethod.POST,"/teams/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/players/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/matches/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")

                        // ADMIN and VIEWER both can view data
                        .requestMatchers(HttpMethod.GET, "/teams/**").hasAnyRole("ADMIN", "VIEWER")
                        .requestMatchers(HttpMethod.GET, "/players/**").hasAnyRole("ADMIN", "VIEWER")
                        .requestMatchers(HttpMethod.GET, "/matches/**").hasAnyRole("ADMIN", "VIEWER")
                        .requestMatchers(HttpMethod.GET, "/stats/**").hasAnyRole("ADMIN", "VIEWER")
                        .anyRequest().authenticated())
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration){
        return authenticationConfiguration.getAuthenticationManager();
    }
}
