package com.ecommerce.repositories;

import com.ecommerce.entities.Privilege;
import com.ecommerce.entities.Role;
import com.ecommerce.enums.AccountRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByName(AccountRoleEnum name);
}
