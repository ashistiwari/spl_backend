package com.spl.backend.security;

import com.spl.backend.repo.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;
import java.util.List;

public class CustomerUserDetailsService implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user=userRepository.findByEmailId(email).orElseThrow(()-> new UsernameNotFoundException("user not founnd"));

        return new User(user.getEmailId(),
                        user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name())));
    }
}
