package com.sofiadev.Offispace.repository;

import com.sofiadev.Offispace.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByUserType(String userType);
}
