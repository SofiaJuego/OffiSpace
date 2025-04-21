package com.sofiadev.Offispace.auth;

import com.sofiadev.Offispace.repository.RoleRepository;
import com.sofiadev.Offispace.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

}
