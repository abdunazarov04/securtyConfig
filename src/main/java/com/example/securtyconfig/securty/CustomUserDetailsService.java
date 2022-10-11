package com.company.Frontend.security;

import com.company.Frontend.exception.BadRequestException;
import com.company.Frontend.model.Login;
import com.company.Frontend.repository.LoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private LoginRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Login> optional = repository.findByUsername(username);
        if (optional.isEmpty()){
            throw new BadRequestException("Username not found");
        }
        Login login = optional.get();
        return new CustomUserDetails(login);
    }
}
