package com.sofiadev.Offispace.service.impl;

import com.sofiadev.Offispace.model.User;
import com.sofiadev.Offispace.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    UserDetailsServiceImpl.log.warn("Intento de login fallido. Usuario no encontrado con email: {}", email);
                    return new UsernameNotFoundException("Usuario no encontrado con email:" + email); }) ;
    }

}
