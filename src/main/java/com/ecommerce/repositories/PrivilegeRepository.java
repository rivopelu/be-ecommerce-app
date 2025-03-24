package com.ecommerce.repositories;

import com.ecommerce.entities.Privilege;
import com.ecommerce.enums.PrivilegeEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrivilegeRepository extends JpaRepository<Privilege, String> {
    Optional<Privilege> findByName(PrivilegeEnum name);
}
