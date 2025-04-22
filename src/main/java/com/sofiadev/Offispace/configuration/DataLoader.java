package com.sofiadev.Offispace.configuration;

import com.sofiadev.Offispace.model.Role;
import com.sofiadev.Offispace.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        loadRoles();
    }

    private void loadRoles(){
        if (roleRepository.findByUserType("ADMIN").isEmpty()){
            Role adminRole = new Role();
            adminRole.setUserType("ADMIN");
            roleRepository.save(adminRole);
        }

        if (roleRepository.findByUserType("USER").isEmpty()){
            Role userRole = new Role();
            userRole.setUserType("USER");
            roleRepository.save(userRole);
        }
    }
}
