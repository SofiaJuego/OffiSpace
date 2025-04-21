package com.sofiadev.Offispace.repository;

import com.sofiadev.Offispace.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByUserType(String user_type);
}
